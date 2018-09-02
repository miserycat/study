package guava.utilities;
import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.fail;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class JoinerTest {

  private List<String> list1 = Lists.newArrayList("hello", "world", "cassie", "dong");
  private List<String> list2 = Lists.newArrayList("hello", "world", "cassie", null);
  private Map<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v2");


  @Test
  public void joinOn_Join() {
    String result = Joiner.on("#").join(list1);
    assertThat(result, equalTo("hello#world#cassie#dong"));
  }

  @Test(expected = NullPointerException.class)
  public void joinOn_Join_NullValue() {
    String result = Joiner.on("#").join(list2);
    assertThat(result, equalTo("hello#world#cassie"));
  }

  @Test
  public void joinOn_Join_SkipNullValue() {
    String result = Joiner.on("#").skipNulls().join(list2);
    assertThat(result, equalTo("hello#world#cassie"));
  }

  @Test
  public void joinOn_Join_useForNullValue() {
    String result = Joiner.on("#").useForNull("dong").join(list2);
    assertThat(result, equalTo("hello#world#cassie#dong"));
  }


  @Test
  public void joinOn_Join_appendTo() {
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = Joiner.on("#").appendTo(sb, list1);
    System.out.println(sb2.toString());
    assertThat(sb, sameInstance(sb2));
  }

  @Test
  public void joinOn_Join_appendToFile() {
    try (FileWriter fw = new FileWriter("C:/11.txt")) {
      Joiner.on("#").appendTo(fw, list1);
      assertThat(Files.isFile().test(new File("C:/11.txt")), equalTo(true));
    } catch (IOException e) {
      fail("append to file occur error");
    } finally {
      new File("c:/11.txt").delete();
    }
  }

  @Test
  public void imitate_joiner_withJava8() {
    String result = list2.stream()
        .filter(s -> s != null && s.length() > 0)
        .collect(joining("#"));

    assertThat(result, equalTo("hello#world#cassie"));
  }


  @Test
  public void joinWithMap() {
    String result = Joiner.on('#').withKeyValueSeparator("=").join(map);
    assertThat(result, equalTo("k1=v1#k2=v2"));
  }







}
