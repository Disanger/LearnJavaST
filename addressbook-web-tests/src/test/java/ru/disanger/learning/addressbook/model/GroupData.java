package ru.disanger.learning.addressbook.model;

public class GroupData {
    private int groupID;
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
    }

    @Override
    public int hashCode() {
        return groupName != null ? groupName.hashCode() : 0;
    }

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.groupID = Integer.MAX_VALUE;
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

    public int getGroupID() {
        return groupID;
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

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupID='" + groupID + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
