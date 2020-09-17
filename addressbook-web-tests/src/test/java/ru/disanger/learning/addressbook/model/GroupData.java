package ru.disanger.learning.addressbook.model;

public class GroupData {
    private  int groupID;
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;


    public int getGroupID() {
        return groupID;
    }

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.groupID = 0;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public GroupData(int groupID, String groupName, String groupHeader, String groupFooter) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (groupID != groupData.groupID) return false;
        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    @Override
    public int hashCode() {
        int result = groupID;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupID='" + groupID + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
