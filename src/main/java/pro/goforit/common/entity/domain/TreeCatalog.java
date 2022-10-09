package pro.goforit.common.entity.domain;

import java.io.Serializable;

/**
 * 树型目录
 * @TableName tree_catalog
 */
public class TreeCatalog implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 父目录id
     */
    private Long parentId;

    /**
     * 目录标题
     */
    private String name;

    /**
     * 
     */
    private Long owner;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 父目录id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父目录id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 目录标题
     */
    public String getName() {
        return name;
    }

    /**
     * 目录标题
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public Long getOwner() {
        return owner;
    }

    /**
     * 
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TreeCatalog other = (TreeCatalog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", owner=").append(owner);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}