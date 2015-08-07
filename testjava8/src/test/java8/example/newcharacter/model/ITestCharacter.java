package test.java8.example.newcharacter.model;

/**
 * 此anno 编译前检查 表达式接口是否合法
 */
@FunctionalInterface
public interface ITestCharacter {

	public void testAnno();

	default public void test() {
		System.out.println("default interface fun ");
	}
}
