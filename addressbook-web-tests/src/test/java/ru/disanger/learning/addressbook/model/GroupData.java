package ru.disanger.learning.addressbook.model;

public class GroupData {
    private final String groupID;
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (groupID != null ? !groupID.equals(groupData.groupID) : groupData.groupID != null) return false;
        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = groupID != null ? groupID.hashCode() : 0;
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

    public String getGroupID() {
        return groupID;
    }

    public GroupData(String groupName, String groupHeader, String groupFooter) {
        this.groupID = null;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public GroupData(String groupID, String groupName, String groupHeader, String groupFooter) {
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
}
