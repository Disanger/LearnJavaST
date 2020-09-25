package ru.disanger.learning.addressbook.model;

public class GroupData {
    private int groupID = Integer.MAX_VALUE;
    private String groupName;
    private String groupHeader;
    private String groupFooter;

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

    public GroupData withID(int groupID) {
        this.groupID = groupID;
        return this;
    }

    public GroupData withName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
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

    @Override
    public String toString() {
        return "GroupData{" +
                "groupID='" + groupID + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
