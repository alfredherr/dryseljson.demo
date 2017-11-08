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

public class UserInformation {

	private final String jsonFileForUserInfoPageUi;
	private final String jsonFileForInput;
	private final String jsonFileForOutput;

	public UserInformation() {
		this.jsonFileForUserInfoPageUi = Paths.get(JsonFilePathHelper.getUserInfoUIFolderPath(), "userInfoPage_ui.json").toString();
		this.jsonFileForInput = Paths.get(JsonFilePathHelper.getUserInfoInputFolderPath(), "userInfoPage_in.json")
				.toString();
		this.jsonFileForOutput = Paths.get(JsonFilePathHelper.getUserInfoIOutputFolderPath(), "userInfoPage_out.json")
				.toString();
	}

	@Given("^Joe has opened user information page$")
	public void openUserInformationPage() throws Throwable {
		new AppLaunch().openWebApp();
		new Login().loginAsJoe();
	}

	@When("^Joe saves his demographics information$")
	public void loginAsJoe() {
		try {
			new JsonStepDefHelper().getTestExecutor().executeInputScript(this.jsonFileForUserInfoPageUi, this.jsonFileForInput);
		} catch (final ElementNotEnabledException e) {
			e.printStackTrace();
		}
	}

	@Then("^the demographic information should be displayed in information pan$")
	public void user_information_page_should_be_displayed() {
		try {
			new JsonStepDefHelper().getTestExecutor().executeOutputScript(this.jsonFileForUserInfoPageUi, this.jsonFileForOutput);
		} catch (final ElementNotEnabledException e) {
			e.printStackTrace();
		}
	}
}
