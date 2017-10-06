package com.example.rlard008.monitoringapp.pojo;

/**
 * Created by sudhakar on 3/29/17.
 */

public class Channel
{
    private String last_entry_id;

    private String id;





    private String updated_at;





    private String name;



    private String created_at;

    private String longitude;

    private String latitude;

    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    public String getLast_entry_id ()
    {
        return last_entry_id;
    }

    public void setLast_entry_id (String last_entry_id)
    {
        this.last_entry_id = last_entry_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getField5 ()
    {
        return field5;
    }

    public void setField5 (String field5)
    {
        this.field5 = field5;
    }

    public String getField4 ()
    {
        return field4;
    }

    public void setField4 (String field4)
    {
        this.field4 = field4;
    }

    public String getField3 ()
    {
        return field3;
    }

    public void setField3 (String field3)
    {
        this.field3 = field3;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getField2 ()
    {
        return field2;
    }

    public void setField2 (String field2)
    {
        this.field2 = field2;
    }

    public String getField7 ()
    {
        return field7;
    }

    public void setField7 (String field7)
    {
        this.field7 = field7;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getField6 ()
    {
        return field6;
    }

    public void setField6 (String field6)
    {
        this.field6 = field6;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getField1 ()
    {
        return field1;
    }

    public void setField1 (String field1)
    {
        this.field1 = field1;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [last_entry_id = "+last_entry_id+", id = "+id+", field5 = "+field5+", field4 = "+field4+", field3 = "+field3+", updated_at = "+updated_at+", field2 = "+field2+", field7 = "+field7+", name = "+name+", field6 = "+field6+", created_at = "+created_at+", longitude = "+longitude+", latitude = "+latitude+", field1 = "+field1+"]";
    }
}
