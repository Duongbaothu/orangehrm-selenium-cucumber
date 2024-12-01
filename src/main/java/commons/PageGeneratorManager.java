package commons;

import pageObjects.AdminPageObjects.EmploymentStatusPageObject;
import pageObjects.AdminPageObjects.JobTitlePageObject;
import pageObjects.AdminPageObjects.PayGradePageObject;
import pageObjects.AdminPageObjects.SystemUsersPageObject;
import pageObjects.PIMPageObjects.*;
import org.openqa.selenium.WebDriver;
import utilities.PropertiesConfig;

public class PageGeneratorManager {

    public static AddEmployeePageObject getAddEmployeePage(WebDriver driver){
        return new AddEmployeePageObject(driver);
    }

    public static ContactDetailsPageObject getContactDetailsPage(WebDriver driver){
        return new ContactDetailsPageObject(driver);
    }

    public static DashboardPageObject getDashboardPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }

    public static DependentsPageObject getDependentsPage(WebDriver driver){
        return new DependentsPageObject(driver);
    }

    public static EmergencyContactsPageObject getEmergencyContactsPage(WebDriver driver){
        return new EmergencyContactsPageObject(driver);
    }

    public static EmployeeJobPageObject getEmployeeJobPage(WebDriver driver){
        return new EmployeeJobPageObject(driver);
    }

    public static EmployeeListPageObject getEmployeeListPage(WebDriver driver){
        return new EmployeeListPageObject(driver);
    }

    public static ImmigrationPageObject getImmigrationPage(WebDriver driver){
        return new ImmigrationPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver, PropertiesConfig propertiesConfig) {
        return new LoginPageObject(driver, propertiesConfig);
    }

    public static PersonalDetailsPageObject getPersonalDetailsPage(WebDriver driver){
        return new PersonalDetailsPageObject(driver);
    }

    public static ChangeProfilePicturePageObject getChangeProfilePicturePage(WebDriver driver){
        return new ChangeProfilePicturePageObject(driver);
    }

    public static QualificationsPageObject getQualificationsPage(WebDriver driver){
        return new QualificationsPageObject(driver);
    }

    public static ReportToPageObject getReportToPage(WebDriver driver){
        return new ReportToPageObject(driver);
    }

    public static SalaryPageObject getSalaryPage(WebDriver driver) {
        return new SalaryPageObject(driver);
    }

    public static SystemUsersPageObject getSystemUsersPage(WebDriver driver){
        return new SystemUsersPageObject(driver);
    }

    public static JobTitlePageObject getJobTitlePage(WebDriver driver){
        return new JobTitlePageObject(driver);
    }

    public static PayGradePageObject getPayGradePage(WebDriver driver){
        return new PayGradePageObject(driver);
    }

    public static EmploymentStatusPageObject getEmploymentStatusPage(WebDriver driver){
        return new EmploymentStatusPageObject(driver);
    }


}
