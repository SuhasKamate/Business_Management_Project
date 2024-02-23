import io.github.bonigarcia.wdm.WebDriverManager
import io.github.bonigarcia.wdm.config.DriverManagerType
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

environments {



	firefox {
		FirefoxOptions options = new FirefoxOptions()
		options.setCapability("acceptInsecureCerts", true)
		options.addArguments("--headless")
		driver = {
			DriverManagerType firefox = DriverManagerType.FIREFOX
			WebDriverManager.getInstance(firefox).setup()
			def tmpDriver = new FirefoxDriver(options)
			tmpDriver.manage().window().maximize()
			return tmpDriver
		}
	}


}

atCheckWaiting = true
waiting {
	timeout = 15
	retryInterval = 0.5
	presets {
		slow {
			timeout = 30
			retryInterval = 1
		}
		medium {
			timeout = 22
			retryInterval = 0.5
		}
		fast {
			timeout = 10
		}
		waitOne {
			timeout = 1
		}
		verySlow {
			timeout = 150
			retryInterval = 1
		}
	}
}



reportOnTestFailureOnly = true //takes screenshot only if a failure occurs
//quitCachedDriverOnShutdown = false //Use this if you want to prevent browser from closing
