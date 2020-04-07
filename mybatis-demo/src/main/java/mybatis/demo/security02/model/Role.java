package mybatis.demo.security02.model;

public class Role {
    private Integer id;
    private String name;
    private String namezw;
    //省略getter/setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamezw() {
        return namezw;
    }

    public void setNamezw(String namezw) {
        this.namezw = namezw;
    }
}
