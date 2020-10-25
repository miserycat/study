package security;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;

class Person {

	public final String name;

	public PublicKey publicKey;
	private PrivateKey privateKey;
	private SecretKey secretKey;

	public Person(String name) {
		this.name = name;
	}

	// ���ɱ���KeyPair:
	public void generateKeyPair() {
		try {
			KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
			kpGen.initialize(512);
			KeyPair kp = kpGen.generateKeyPair();
			this.privateKey = kp.getPrivate();
			this.publicKey = kp.getPublic();
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}

	public void generateSecretKey(byte[] receivedPubKeyBytes) {
		try {
			// ��byte[]�ָ�PublicKey:
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
			KeyFactory kf = KeyFactory.getInstance("DH");
			PublicKey receivedPublicKey = kf.generatePublic(keySpec);
			// ���ɱ�����Կ:
			KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
			keyAgreement.init(this.privateKey); // �Լ���PrivateKey
			keyAgreement.doPhase(receivedPublicKey, true); // �Է���PublicKey
			// ����AES��Կ:
			this.secretKey = keyAgreement.generateSecret("AES");
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}

	public void printKeys() {
		System.out.printf("Name: %s\n", this.name);
		System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
		System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
		System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey.getEncoded()));
	}

	// ���ͼ�����Ϣ:
	public String sendMessage(String message) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
			byte[] data = cipher.doFinal(message.getBytes("UTF-8"));
			return Base64.getEncoder().encodeToString(data);
		} catch (GeneralSecurityException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// ���ռ�����Ϣ������:
	public String receiveMessage(String message) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
			byte[] data = cipher.doFinal(Base64.getDecoder().decode(message));
			return new String(data, "UTF-8");
		} catch (GeneralSecurityException | IOException e) {
			throw new RuntimeException(e);
		}
	}

}

public class DH {

	public static void main(String[] args) {
		// Bob��Alice:
		Person bob = new Person("Bob");
		Person alice = new Person("Alice");

		// ��������KeyPair:
		bob.generateKeyPair();
		alice.generateKeyPair();

		// ˫���������Ե�PublicKey:
		// Bob����Alice��PublicKey�����Լ��ı�����Կ:
		bob.generateSecretKey(alice.publicKey.getEncoded());
		// Alice����Bob��PublicKey�����Լ��ı�����Կ:
		alice.generateSecretKey(bob.publicKey.getEncoded());

		// ���˫���ı�����Կ�Ƿ���ͬ:
		bob.printKeys();
		alice.printKeys();

		// ˫����SecretKey��ͬ������ͨ�Ž�ʹ��SecretKey��Ϊ��Կ����AES�ӽ���:
		String msgBobToAlice = bob.sendMessage("Hello, Alice!");
		System.out.println("Bob -> Alice: " + msgBobToAlice);
		String aliceDecrypted = alice.receiveMessage(msgBobToAlice);
		System.out.println("Alice decrypted: " + aliceDecrypted);
	}
}
