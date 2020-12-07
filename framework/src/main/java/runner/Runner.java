package runner;

import io.cucumber.core.cli.Main;

public class Runner {

	public static void main(String[] args) {
		Main.main("src/test/resources/features" , "-g","hooks" , "-g" ,
				"classpath:stepDefenitions" ,"-p" ,"pretty" , "-m" ,"--monochrome" ,"-p","html:target/cucumber-html-report.html" ,"-p","json:cucumber-json-report.json" ,"-t","@param");
 
	}

}
