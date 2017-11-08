/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 * Author: Kuldeep Sinh Chauhan (@KuldeepSinhC)
 * emails: kuldeeps@orionhealth.com, chauhan.kuldeep.sinh@gmail.com
 *
 * This file is provided to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an  "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,  either express or implied.  See the License for the specific language governing    
 * permissions and limitations under the License.
 */
package com.orchestral.automation.dryseljson.demo.stepdefs;

import java.nio.file.Paths;

import com.orchestral.automation.dryselcore.eventlib.ElementNotEnabledException;
import com.orchestral.automation.dryseljson.demo.helper.JsonFilePathHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppLaunch {

	private final String jsonFileForAppLauncherUi;
	private final String jsonFileForLoginUi;
	private final String jsonFileForInput;
	private final String jsonFileForOutput;

	public AppLaunch() {
		this.jsonFileForAppLauncherUi = Paths.get(JsonFilePathHelper.getAppLauncherUIFolderPath(), "webBrowser_ui.json")
				.toString();
		this.jsonFileForInput = Paths.get(JsonFilePathHelper.getAppLauncherInputFolderPath(), "webBrowser_in.json")
				.toString();
		this.jsonFileForOutput = Paths.get(JsonFilePathHelper.getAppLauncherOutputFolderPath(), "webBrowser_out.json")
				.toString();
		this.jsonFileForLoginUi = Paths.get(JsonFilePathHelper.getLoginUIFolderPath(), "loginPage_ui.json").toString();
	}

	@Given("^Joe is a user$")
	public void joe_is_a_user() {
	}

	@When("^Joe enters correct URL of the web app$")
	public void openWebApp() {
		try {
			new JsonStepDefHelper().getTestExecutor().executeInputScript(this.jsonFileForAppLauncherUi, this.jsonFileForInput);
		} catch (final ElementNotEnabledException e) {
			e.printStackTrace();
		}
	}

	@Then("^login page of the web app should be displayed$")
	public void login_page_of_the_web_app_should_be_displayed() throws Throwable {
		new JsonStepDefHelper().getTestExecutor().executeOutputScript(this.jsonFileForLoginUi, this.jsonFileForOutput);
	}
}
