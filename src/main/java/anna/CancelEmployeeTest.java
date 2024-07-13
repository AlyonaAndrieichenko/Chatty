package employeeTestSuite;

//import baseTest.BaseTest;
//import dataBase.employee.EmployeeRepository;
//import objects.Employee;
//import org.junit.Before;
//import org.junit.Test;
//import pageObjects.employee.EmployeesPage;
//import registry.EmployeeRegistry;

public class CancelEmployeeTest  { // extends BasePage
//    private String firstName;
//    private String lastName;
//
//    @Before
//    public void setUp() throws Exception {
//        this.firstName = "Vzi";
//        this.lastName = "surname";
//
//    }
//
//    @Test
//    public void testCancelEmployeePositive() {
//
//        EmployeesPage page = new EmployeesPage (driver)
//                .openViaMenuLink()
//                .clickCreateEmployee()
//                .inputFirstName(firstName)
//                .inputLastName(lastName)
//                .cancelEmployee()
//                .readAllDataFromTable();
//
//        defineTestResultFalse(page.readAllEmployeeFirstNames().contains(firstName));
//        defineTestResultFalse(page.readAllEmployeeLastNames().contains(lastName));
//
//        page.enterTextInSearchField(firstName + " " + lastName)
//                .readAllDataFromTable();
//
//        defineTestResultTrue(page.getTableData().isEmpty());
//        defineTestResultTrue(EmployeeRepository.getInstance().findEmployeeByNameAndSurname(firstName, lastName).isEmpty());
//    }
}
