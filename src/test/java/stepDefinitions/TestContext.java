package stepDefinitions;

public class TestContext {
    //Mục đích của TestContext: luôn giữ cho dataContext là 1 đối tượng duy nhất
    // vì nếu dùng trực tiếp, dataContext sẽ khởi tạo nhiều lần khi inject qua nhiều class
    public DataContext dataContext;

    public TestContext() {
        dataContext = new DataContext();
    }
    public DataContext getDataContext() {
        return dataContext;
    }
}
