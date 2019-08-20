package web.example.pojo;

public class Role
{
    private String id;
    private String name;
    private String sex;
    private String sth;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSth()
    {
        return sth;
    }

    public void setSth(String sth)
    {
        this.sth = sth;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", sth='").append(sth).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
