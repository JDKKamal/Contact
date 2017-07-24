package com.jdkgroup.contact.model;

/**
 * Created by kamlesh on 7/23/2017.
 */

public class ContactListModel
{
    private String id, name, cellno, image;

    public ContactListModel(String id, String name, String cellno, String image) {
        this.id = id;
        this.name = name;
        this.cellno = cellno;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellno() {
        return cellno;
    }

    public void setCellno(String cellno) {
        this.cellno = cellno;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
