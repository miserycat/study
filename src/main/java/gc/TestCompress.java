package gc;

public class TestCompress {
  public static void main(String[] args) {
    char[] chars = {'a','a','b','b','c','c','c'};
//    convert(chars);
    System.out.println(compress(chars));
    System.out.println(chars);
  }

  public static int compress(char[] chars) {
    if (chars == null || chars.length == 0) {
      return 0;
    }
    if (chars.length == 1) {
      return 1;
    }
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i = 0; i < chars.length; i++) {
      if (i == chars.length -1) {
        if(chars[chars.length - 1] != chars[chars.length - 2]) {
          sb.append(chars[i]);
        } else if(count != 1){
          sb.append(chars[i]).append(count);
        }
        break;
      }
      if (chars[i] == chars[i + 1]) {
        count++;
      } else {
        sb.append(chars[i]);
        if (count != 1) {
          sb.append(count);
          count = 1;
        }
      }
    }
    char[] newChars = sb.toString().toCharArray();
    for (int i = 0; i < newChars.length; i++) {
        chars[i] = newChars[i];
    }
    return newChars.length;
  }

  public static void convert(char[] chars) {
    chars = null;
//    chars[0] = 'x';
//    chars[1] = 'y';
    return;
  }

}
