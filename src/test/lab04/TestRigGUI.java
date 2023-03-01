package test.lab04;

public class TestRigGUI {
	
	public static void main(String... args) throws Exception {
		org.antlr.v4.gui.TestRig.main(new String[]{"parser.Cmm", "ast", "-gui", "input.txt"});
	}
	

}
