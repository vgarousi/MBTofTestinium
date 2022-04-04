package com.mbt.testiniumcloud.modelImplementation;

import com.mbt.testiniumcloud.driver.Driver;
import com.mbt.testiniumcloud.methods.Methods;
import com.mbt.testiniumcloud.methods.MethodsUtil;
import com.mbt.testiniumcloud.utils.CoverageValue;
import com.mbt.testiniumcloud.utils.ExcelMapData;
import com.mbt.testiniumcloud.utils.SharedNodeControl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.graalvm.polyglot.Value;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.*;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100)
public class ProjectDetailSuites extends ExecutionContext implements org.graphwalker.Project_Detail_Suites {

    private static final Logger logger = LogManager.getLogger(ProjectDetailSuites.class);
    Methods methods;
    MethodsUtil methodsUtil;
    ExcelMapData excelMapData;

    public ProjectDetailSuites() {

        methods = new Methods();
        methodsUtil = new MethodsUtil();
        excelMapData = new ExcelMapData();
        Configurator.setLevel(getLogger(ProjectDetailSuites.class), Level.toLevel(Driver.modelImplLogLevel));
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

    public void v_Verify_In_Reports_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/report",75,"startWith"));
        String currentUrl = methods.getCurrentUrl().trim();
        Assert.assertTrue("", currentUrl.equals("https://testinium.io/report")
                || currentUrl.startsWith("https://testinium.io/report/project/")
                || currentUrl.startsWith("https://testinium.io/report/plan/"));
        methods.checkElementVisible(methods.getBy("reportsLogoTitleInReports"));
        methods.checkElementVisible(methods.getBy("createButtonInReports"));
        methods.checkElementVisible(methods.getBy("exportTableInReports"));
        methods.checkElementVisible(methods.getBy("projectsInReports"));
        methods.checkElementVisible(methods.getBy("suitesInReports"));
        methods.checkElementVisible(methods.getBy("dateFromInReports"));
        methods.checkElementVisible(methods.getBy("dateToInReports"));
        methods.checkElementVisible(methods.getBy("showOnlyFailedTestsInReports"));
        methods.checkElementVisible(methods.getBy("tableInReports"));
        methods.checkElementVisible(methods.getBy("tableCheckboxInReports"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void v_Verify_Suite_Is_Available() {

        By planBy = methods.getByWithKeySetValue("tablePlanWithPlanNameInProjectDetailSuites"
                , String.valueOf(methods.getValueInTestMap("deletePlan")));
        methods.checkElementVisible(planBy);
    }

    public void e_No_Action() {

    }

    public void v_Verify_Suite_Is_Not_Running() {

        methodsUtil.waitByMilliSeconds(200);
        Assert.assertTrue("", methods.isElementInVisible(methods
                .getBy("TestRunSuccessfullStarted"),30));
    }

    public void v_Verify_Suite_Is_Running() {

        methods.checkElementVisible(methods.getBy("TestRunSuccessfullStarted"));
        methodsUtil.waitByMilliSeconds(200);
    }

    public void e_click_Yes() {

        By yesButtonBy = methods.getBy("popupYesButtonInProjects");
        methods.checkElementVisible(yesButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(yesButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(yesButtonBy);
        methods.putValueInTestMap("testRun",true);
        setAttribute("suiteRunYes", Value.asValue(false));
    }

    public void e_Click_Report() {

        By planNameBy = methods.getBy("tablePlanNameWithReportButtonInProjectDetailSuites");
        methods.checkElementVisible(planNameBy);
        String planName = methods.getText(planNameBy).trim();
        methods.putValueInTestMap("reportPlan", planName);
        By planReportButtonBy = methods.getByWithKeySetValue("reportButtonWithPlanNameInProjectDetailSuites",planName);
        methods.checkElementVisible(planReportButtonBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementClickable(planReportButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(planReportButtonBy);
    }

    public void e_Click_Run() {

        By planNameBy = methods.getBy("tablePlanNameInProjectDetailSuites");
        methods.checkElementVisible(planNameBy);
        String planName = methods.getText(planNameBy).trim();
        methods.putValueInTestMap("runningPlan", planName);
        By planRunButtonBy = methods.getByWithKeySetValue("runButtonWithPlanNameInProjectDetailSuites",planName);
        methods.checkElementVisible(planRunButtonBy);
        methods.checkElementClickable(planRunButtonBy);
        methods.clickElement(planRunButtonBy);
        if(!Boolean.parseBoolean(methods.getValueInTestMap("testRun").toString())
                && methods.getValueInTestMap("currentProject").toString().trim()
                .equals(methods.getValueInTestMap("editProject").toString())){
            setAttribute("suiteRunYes",Value.asValue(true));
        }
        else {
        setAttribute("suiteRunYes",Value.asValue(false));
        }
    }

    public void v_Verify_In_Project_Detail_Suites_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/plans",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailSuites"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("fromInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("toInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("runningTestCheckboxInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("failedOnesInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("tableInProjectDetailSuites"));
        methods.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));

        if (methods.isElementVisible(methods.getBy("tableElementInProjectDetailSuites"),2)){

            methods.checkElementVisible(methods.getBy("runButtonInProjectDetailSuites"));
            methods.checkElementVisible(methods.getBy("editButtonInProjectDetailSuites"));
            methods.checkElementVisible(methods.getBy("deleteButtonInProjectDetailSuites"));
            setAttribute("hasProjectAPlan",Value.asValue(true));
            if (methods.isElementVisible(methods.getBy("reportButtonInProjectDetailSuites"),2)){
                setAttribute("isReportAvailable",Value.asValue(true));
            }else {
                setAttribute("isReportAvailable",Value.asValue(false));
            }
        }else {
            setAttribute("hasProjectAPlan",Value.asValue(false));
            setAttribute("isReportAvailable",Value.asValue(false));
        }

        /**
         if(!Boolean.parseBoolean(methods.getValueInTestMap("editProjectRun").toString())
                && String.valueOf(methods.getValueInTestMap("currentProject"))
                .equals(methods.getValueInTestMap("editProject").toString())){
            setAttribute("suiteRunYes",true);
            methods.putValueInTestMap("editProjectRun",true);
        }*/
    }

    public void e_Click_No() {

        By noButtonBy = methods.getBy("popupNoButtonInProjects");
        methods.checkElementVisible(noButtonBy);
        methods.checkElementClickable(noButtonBy);
        methodsUtil.waitBySeconds(1);
        methods.clickElement(noButtonBy);
    }

    public void v_Control_Are_You_Sure_Message() {

        methodsUtil.waitByMilliSeconds(500);
        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitByMilliSeconds(500);
    }

    public void e_Click_Delete() {

        By planNameBy = methods.getBy("tablePlanNameInProjectDetailSuites");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String planName = methods.getText(planNameBy).trim();
        methods.putValueInTestMap("deletePlan", planName);
        By planDeleteButtonBy = methods.getByWithKeySetValue("deleteButtonWithPlanNameInProjectDetailSuites", planName);
        methods.checkElementVisible(planDeleteButtonBy);
        methods.checkElementClickable(planDeleteButtonBy);
        methods.clickElement(planDeleteButtonBy);
    }

    public void v_Verify_In_Project_Detail_Summary_Page_SHARED() {

        /**
        Assert.assertTrue("", methods.doesUrl("https://testinium.io/project/detail/",
                75,"startWith"));
        Assert.assertTrue("", methods.doesUrl("/summary",75,"endWith"));
        methods.checkElementVisible(methods.getByWithKeySetValue("logoWithProjectNameInProjectDetailSummary"
                , String.valueOf(methods.getValueInTestMap("currentProject"))));
        methods.checkElementVisible(methods.getBy("createNewSuitePanelInProjectDetailSummary"));
        methods.checkElementVisible(methods.getBy("latestSuiteRunsTableWithTextInProjectDetailSummary"));
        methods.checkElementVisible(methods.getBy("propertiesTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("summaryTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("scenariosTabInProjectDetail"));
        methods.checkElementVisible(methods.getBy("suitesTabInProjectDetail"));

        methods.checkElementVisible(methods.getBy("dashboardButton"));
        methods.checkElementVisible(methods.getBy("projectsTab"));
        methods.checkElementVisible(methods.getBy("allScenariosTab"));
        methods.checkElementVisible(methods.getBy("allSuitesTab"));
        methods.checkElementVisible(methods.getBy("reportsTab"));
        methods.checkElementVisible(methods.getBy("automatedTestTab"));
         */
    }

    public void e_Click_Project_Detail_Summary_Tab() {

        By summaryTabBy = methods.getBy("summaryTabInProjectDetail");
        methods.checkElementVisible(summaryTabBy);
        methods.checkElementClickable(summaryTabBy);
        methodsUtil.waitByMilliSeconds(500);
        methods.clickElement(summaryTabBy);
    }

    public void e_Click_Edit() {

        By planNameBy = methods.getBy("tablePlanNameInProjectDetailSuites");
        methods.checkElementVisible(planNameBy);
        methodsUtil.waitByMilliSeconds(200);
        String planName = methods.getText(planNameBy).trim();
        methods.putValueInTestMap("editPlanName", planName);
        methods.putValueInTestMap("editProjectName", methods.getValueInTestMap("currentProject").toString());
        By planEditButtonBy = methods.getByWithKeySetValue("editButtonWithPlanNameInProjectDetailSuites", planName);
        methods.checkElementVisible(planEditButtonBy);
        methods.checkElementClickable(planEditButtonBy);
        methods.clickElement(planEditButtonBy);
    }

    public void v_control_Are_You_Sure_Message() {

        methods.checkElementVisible(methods.getBy("popupTitleInProjects"));
        methods.checkElementVisible(methods.getBy("popupYesButtonInProjects"));
        methods.checkElementVisible(methods.getBy("popupNoButtonInProjects"));
        methodsUtil.waitByMilliSeconds(200);
    }

    public void v_Verify_In_Plan_Edit_Page_SHARED() {

        Assert.assertTrue("", methods.doesUrl("https://testinium.io/plan/edit/",
                75,"startWith"));
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
    }

    public void e_no_action() {

    }
}
