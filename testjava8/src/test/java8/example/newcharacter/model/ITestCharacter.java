package test.java8.example.newcharacter.model;

/**
 * ��anno ����ǰ��� ���ʽ�ӿ��Ƿ�Ϸ�
 */
@FunctionalInterface
public interface ITestCharacter {

	public void testAnno();

	default public void test() {
		System.out.println("default interface fun ");
	}
}
