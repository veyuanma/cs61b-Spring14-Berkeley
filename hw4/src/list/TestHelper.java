package list;

/*
 * From https://github.com/buildgood/CS61B/blob/master/hw/hw4/list/TestHelper.java
 */
public class TestHelper {
	static void verify(boolean invariant, String message){
		if(!invariant){
			System.out.println("*** ERROR: "+message);
			Thread.dumpStack();
		}
	}
}
