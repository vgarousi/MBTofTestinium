package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SharedNodeControl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.graalvm.polyglot.Value;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class AllSuites extends ExecutionContext implements org.graphwalker.All_Suites {

    private static final Logger logger = LogManager.getLogger(AllSuites.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public AllSuites() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        methods.putValueInTestMap("allSuitesMobile",false);
        Configurator.setLevel(getLogger(AllSuites.class), Level.toLevel(Driver.modelImplLogLevel));
    }

    @BeforeElement
    public void beforeElement() {

        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
        excelMapData.setBeforeElementData(getModel(), getCurrentElement());
        SharedNodeControl.sharedNodeElementControl(getCurrentElement());
    }

    @AfterElement
    public void afterElement() {

        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    @BeforeExecution
    public void setup() {

    }

    @AfterExecution
    public void cleanup() {

    }

    public void e_click_Mobile_Checbox() {

        By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
        By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
        methods.checkElementClickable(iosOptionBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(iosOptionBy);
        methods.checkElementVisible(androidOptionBy);
        methods.checkElementClickable(androidOptionBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(androidOptionBy);
        methods.putValueInTestMap("allSuitesMobile",true);
    }

    public void e_Click_Create_Button() {

        By createButtonBy = methods.getBy("createPlanInAllSuites");
        methods.checkElementVisible(createButtonBy);
        methods.checkElementClickable(createButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(createButtonBy);
        methods.putValueInTestMap("projectSelectedForPlan",false);
    }

    public void v_Verify_In_All_Suites_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan",75,"equal"));
        methods.checkElementVisible(methods.getBy("allSuitesLogoTitleInAllSuites"));
        By selectProjectBy = methods.getBy("selectProjectInAllSuites");
        methods.checkElementVisible(selectProjectBy);
        methods.checkElementVisible(methods.getBy("exportTableInAllSuites"));
        methods.checkElementVisible(methods.getBy("createPlanInAllSuites"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methods.checkElementVisible(methods.getBy("mobileIosShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("mobileAndroidShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webAllShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webFirefoxShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webChromeShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webIEShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webSafariShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webOperaShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("webEdgeShowOnlyOptionInAllSuites"));
        methods.checkElementVisible(methods.getBy("runningSuitesShowOnlyOptionInAllSuites"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));

        methodsUtil.waitByMilliSeconds(400);

        if(methods.getAttribute(methods.getByWithKeySetValue("checkboxShowOnlyOptionKeyValueInAllSuites","Mobile (iOS)")
                ,"class").contains("checked")){
            By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
            methods.checkElementVisible(iosOptionBy);
            methods.checkElementClickable(iosOptionBy);
            methods.clickElement(iosOptionBy);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
            methods.checkElementVisible(iosOptionBy);
        }
        if(methods.getAttribute(methods.getByWithKeySetValue("checkboxShowOnlyOptionKeyValueInAllSuites","Mobile (ANDROID)")
                ,"class").contains("checked")){
            By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
            methods.checkElementVisible(androidOptionBy);
            methods.checkElementClickable(androidOptionBy);
            methods.clickElement(androidOptionBy);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
            methods.checkElementVisible(androidOptionBy);
        }
        if(methods.getAttribute(methods.getByWithKeySetValue("checkboxShowOnlyOptionKeyValueInAllSuites","Web (All)")
                ,"class").contains("checked")){
            By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
            methods.checkElementVisible(webAllOptionBy);
            methods.checkElementClickable(webAllOptionBy);
            methods.clickElement(webAllOptionBy);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
            methods.checkElementVisible(webAllOptionBy);
        }

        //if(!methods.getFirstSelectedOption(selectProjectBy)
          //      .getText().trim().equals("All Projects")){
        methodsUtil.waitByMilliSeconds(200);
        methods.selectByVisibleText(selectProjectBy,
                methods.getValueInTestMap("appiumProject").toString());
        methodsUtil.waitByMilliSeconds(200);
            methods.checkElementVisible(selectProjectBy);
            methods.selectByVisibleText(selectProjectBy,"All Projects");
            methods.checkElementVisible(selectProjectBy);
        methodsUtil.waitByMilliSeconds(500);
            methods.checkElementVisible(methods.getBy("tableInAllSuites"));
            methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        //}

        methods.putValueInTestMap("currentProject", methods.getValueInTestMap("optionalProject").toString());
    }

    public void v_Verify_Suite_Is_Available() {

        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methodsUtil.waitByMilliSeconds(500);
        String projectName = String.valueOf(methods.getValueInTestMap("deleteProjectNameInAllSuites"));
        String planName = String.valueOf(methods.getValueInTestMap("deletePlanNameInAllSuites"));
        Assert.assertTrue("",methods.isElementVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
    }

    public void e_click_Web_Checkbox() {

        By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
        methods.checkElementVisible(webAllOptionBy);
        methods.checkElementClickable(webAllOptionBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(webAllOptionBy);
    }

    //delete
    public void e_Click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(yesButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(yesButtonBy);
    }

    public void v_Verify_In_Create_Plan_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/create",75,"startWith"));
        methods.checkElementVisible(methods.getBy("logoInCreatePlan"));
        methods.checkElementVisible(methods.getBy("projectNameInCreatePlan"));
        methods.checkElementVisible(methods.getBy("suiteNameInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("cancelButtonInCreatePlan"));
        methods.checkElementVisible(methods.getBy("saveButtonInCreatePlan"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_Click_Report() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        //By suiteNameBy = methods.getByWithKeySetValue("tableSuiteNameWithProjectNameReportInAllSuites", projectName);
        By suiteNameBy = methods.getByWithKeySetValue("tableSuiteNameWithProjectNameNumberReportInAllSuites",
                projectName + "!!" + "last()");
        methods.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(500);
        String planName = methods.getText(suiteNameBy).trim().split(" ")[0];
        By reportButtonBy = methods.getByWithKeySetValue("reportButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(reportButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(reportButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(reportButtonBy);
        methods.putValueInTestMap("currentPlan", planName);
    }

    public void v_Control_Suite_Table_For_Only_Selected_Project() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        By tableSuiteNameBy = methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + "");
        By tableSuiteNameNotProjectBy = methods.getByWithKeySetValue("tablePlanKeyValueNotProjectInAllSuites"
                , projectName + "!!" + "");
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(tableSuiteNameBy);
        Assert.assertTrue("", methods.isElementInVisible(tableSuiteNameNotProjectBy,30));
    }

    public void v_Control_Suite_Table_In_All_Suites() {

        methods.checkElementVisible(methods.getBy("selectProjectInAllSuites"));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methodsUtil.waitByMilliSeconds(200);

        if(methods.isElementVisible(methods.getBy("runButtonTableInAllSuites"), 2)){

            setAttribute("hasProjectASuite", Value.asValue(true));

            if(methods.isElementVisible(methods.getBy("reportButtonTableInAllSuites"),2)){

                setAttribute("hasProjectAReport", Value.asValue(true));
            }else {

                setAttribute("hasProjectAReport", Value.asValue(false));
            }
        }else {
            setAttribute("hasProjectASuite", Value.asValue(false));
            setAttribute("hasProjectAReport", Value.asValue(false));
        }

       //mobile ignore

        if(Boolean.parseBoolean(methods.getValueInTestMap("allSuitesMobile").toString())){

            setAttribute("hasProjectASuite", Value.asValue(false));
            methods.putValueInTestMap("allSuitesMobile", Value.asValue(false));
        }
    }

    public void v_Control_Are_You_Sure_Message() {

        methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitBySeconds(1);
    }

    public void e_Click_Delete() {

        By projectNameBy = methods.getByWithKeySetValue("tableProjectNameInAllSuites","last()");
        By tableSuiteNameBy = methods.getByWithKeySetValue("tableSuiteNameInAllSuites","last()");
        methods.checkElementVisible(projectNameBy);
        methodsUtil.waitByMilliSeconds(300);
        methods.checkElementVisible(tableSuiteNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String projectName = methods.getText(projectNameBy).trim();
        //split eklendi editPlan1 (1) yüzünden
        String planName = methods.getText(tableSuiteNameBy).trim().split(" ")[0];
        methods.putValueInTestMap("deleteProjectNameInAllSuites", projectName);
        methods.putValueInTestMap("deletePlanNameInAllSuites", planName);
        By deleteButtonBy = methods.getByWithKeySetValue("deleteButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(deleteButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(deleteButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(deleteButtonBy);
    }

    /**
     * TODO: e_no_action
     */
    public void e_Clear_Checkbox() {

    }

    public void e_Click_Edit() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        By planNameBy = methods.getByWithKeySetValue("tableSuiteNameByProjectNameInAllSuites",
                projectName + "!!1");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String planName = methods.getText(planNameBy).trim().split(" ")[0];;
        By editButtonBy = methods.getByWithKeySetValue("editButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(editButtonBy);
        methods.checkElementClickable(editButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(editButtonBy);
        methods.putValueInTestMap("editPlanName", planName);
        methods.putValueInTestMap("editProjectName", projectName);
    }

    public void v_Verify_In_Report_Detail_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report/detail/",75,"startWith"));
        methods.checkElementVisible(methods.getBy("exportTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("exportPdfInReportDetail"));
        methods.checkElementVisible(methods.getBy("executionDetailTableInReportDetail"));
        //methods.checkElementVisible(methods.getBy("executionDetailTestCaseInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultTableInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultStatusInReportDetail"));
        methods.checkElementVisible(methods.getBy("testResultDetailButtonInReportDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_control_Are_You_Sure_Message() {

        methodsUtil.waitBySeconds(1);
        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitBySeconds(1);
    }

    /**
     * TODO: düzenle
     * AssertionError: By.xpath: //table[contains(@class,"table")]/tbody/tr[./td[./span[text()="PROJECT NAME"] and text()="testiniumProjectTemp"] and ./td/button[contains(text(),"REPORT") and not(disabled)]]/td[./span[text()="SUITE NAME"]] elementi görüntülenemedi.
     */

    public void e_Click_Mobile_Checbox() {

        By iosOptionBy = methods.getBy("mobileIosShowOnlyOptionInAllSuites");
        By androidOptionBy = methods.getBy("mobileAndroidShowOnlyOptionInAllSuites");
        methods.checkElementVisible(iosOptionBy);
        methods.checkElementClickable(iosOptionBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(iosOptionBy);
        methods.checkElementVisible(androidOptionBy);
        methods.checkElementClickable(androidOptionBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(androidOptionBy);
        methods.putValueInTestMap("allSuitesMobile",true);
    }

    public void e_Click_Web_Checkbox() {

        By webAllOptionBy = methods.getBy("webAllShowOnlyOptionInAllSuites");
        methods.checkElementVisible(webAllOptionBy);
        methods.checkElementClickable(webAllOptionBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(webAllOptionBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_Suite_Is_Not_Running() {

        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        Assert.assertTrue("Hata", methods
                .isElementInVisible(methods.getBy("TestRunSuccessfullStarted"),30));
    }

    public void v_Verify_Suite_Is_Running() {

        Assert.assertTrue("Test Başlatılamadı...", methods
                .isElementVisible(methods.getBy("TestRunSuccessfullStarted"),60));
        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        String planName = String.valueOf(methods.getValueInTestMap("currentPlan"));
        methods.checkElementVisible(methods.getByWithKeySetValue("testRunningSpinnerInNewSuite"
                , planName),120);
    }

    // run
    public void e_click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(yesButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(yesButtonBy);
        setAttribute("isRunYes", Value.asValue(false));
    }

    public void e_Click_Run() {

        String projectName = String.valueOf(methods.getValueInTestMap("currentProject"));
        By suiteNameBy = methods.getByWithKeySetValue("tableSuiteNameWithProjectNameInAllSuites", projectName);
        methods.checkElementVisible(suiteNameBy);
        methodsUtil.waitByMilliSeconds(400);
        String planName = methods.getText(suiteNameBy).trim().split(" ")[0];;
        By runButtonBy = methods.getByWithKeySetValue("runButtonTableSuiteNameKeyValueInAllSuites"
                , projectName + "!!" + planName);
        methods.checkElementVisible(runButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.isElementEnabled(runButtonBy,30);
        methods.checkElementClickable(runButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElementForStaleElement(runButtonBy);
        methods.putValueInTestMap("currentPlan", planName);
    }

    public void e_NO_action() {

    }

    public void e_Select_All_Projects() {

        By projectSelectBy = methods.getBy("selectProjectInAllSuites");
        methods.selectByVisibleText(projectSelectBy
                , "All Projects");
    }

    public void e_NO_Action() {

    }

    public void e_no_Action() {

    }

    public void v_Verify_Suite_Is_Not_Available() {

        methods.checkElementVisible(methods.getBy("tableInAllSuites"));
        methods.checkElementVisible(methods.getBy("suiteForTableInAllSuites"));
        String projectName = String.valueOf(methods.getValueInTestMap("deleteProjectNameInAllSuites"));
        String planName = String.valueOf(methods.getValueInTestMap("deletePlanNameInAllSuites"));
        Assert.assertTrue("",methods.isElementInVisible(methods.getByWithKeySetValue("tablePlanKeyValueInAllSuites"
                , projectName + "!!" + planName),30));
    }

    public void e_Select_A_Project() {

        By projectSelectBy = methods.getBy("selectProjectInAllSuites");
        methods.selectByVisibleText(projectSelectBy
                , String.valueOf(methods.getValueInTestMap("currentProject")));
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(noButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void e_click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(noButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/edit/",75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/properties",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoTitleInPlanEdit"
                , String.valueOf(methods.getValueInTestMap("editPlanName"))));
        methods.checkElementVisible(methods.getBy("projectNameInPlanEdit"));
        methods.checkElementVisible(methods.getBy("planNameInPlanEdit"));
        //methods.checkElementVisible(methods.getBy("enableSwitchInPlanEdit"));
        methods.checkElementVisible(methods.getBy("scenarioNameForScenariosPanelInPlanEdit"));
        methods.checkElementVisible(methods.getBy("selectScenariosPanelInCreatePlan"));
        methods.checkElementVisible(methods.getBy("selectScenarioOrderInCreatePlan"));
        methods.checkElementVisible(methods.getBy("cancelButtonInPlanEdit"));
        methods.checkElementVisible(methods.getBy("saveButtonInPlanEdit"));
        methods.checkElementVisible(methods.getBy("applyButtonInPlanEdit"));
        //scenarioForScenariosSelectListInCreatePlan
        //Mac 	1920x1080

        methods.checkElementVisible(methods.getBy("propertiesTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("advancedTabInPlanEdit"));
        methods.checkElementVisible(methods.getBy("scheduleAndNotificationsTabInPlanEdit"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_no_action() {

    }
}
