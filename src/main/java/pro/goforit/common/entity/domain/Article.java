package pro.goforit.common.entity.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName article
 */
public class Article implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long treeCatalogId;

    /**
     * 
     */
    private String title;

    /**
     * 标签 逗号分隔
     */
    private String labels;

    /**
     * 富文本原始字符
     */
    private String content;

    /**
     * 用于检索的文本
     */
    private String originContent;

    /**
     * 封面图片地址
     */
    private String coverImageUrl;

    /**
     * 是否转载
     */
    private Integer ifReprinted;

    /**
     * 转载链接
     */
    private String reprintedUrl;

    /**
     * 是否置顶
     */
    private Integer ifTop;

    /**
     * 是否公开
     */
    private Integer ifPrivate;

    /**
     * 
     */
    private Long heat;

    /**
     * 
     */
    private Integer deleteFlag;

    /**
     * 
     */
    private String remark;

    /**
     * 审核状态
（0：审核中 1：通过  -1：失败 ）
     */
    private Integer status;

    /**
     * 
     */
    private Long createUser;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Long updateUser;

    /**
     * 
     */
    private Date updateTime;

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
     * 
     */
    public Long getTreeCatalogId() {
        return treeCatalogId;
    }

    /**
     * 
     */
    public void setTreeCatalogId(Long treeCatalogId) {
        this.treeCatalogId = treeCatalogId;
    }

    /**
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 标签 逗号分隔
     */
    public String getLabels() {
        return labels;
    }

    /**
     * 标签 逗号分隔
     */
    public void setLabels(String labels) {
        this.labels = labels;
    }

    /**
     * 富文本原始字符
     */
    public String getContent() {
        return content;
    }

    /**
     * 富文本原始字符
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 用于检索的文本
     */
    public String getOriginContent() {
        return originContent;
    }

    /**
     * 用于检索的文本
     */
    public void setOriginContent(String originContent) {
        this.originContent = originContent;
    }

    /**
     * 封面图片地址
     */
    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    /**
     * 封面图片地址
     */
    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    /**
     * 是否转载
     */
    public Integer getIfReprinted() {
        return ifReprinted;
    }

    /**
     * 是否转载
     */
    public void setIfReprinted(Integer ifReprinted) {
        this.ifReprinted = ifReprinted;
    }

    /**
     * 转载链接
     */
    public String getReprintedUrl() {
        return reprintedUrl;
    }

    /**
     * 转载链接
     */
    public void setReprintedUrl(String reprintedUrl) {
        this.reprintedUrl = reprintedUrl;
    }

    /**
     * 是否置顶
     */
    public Integer getIfTop() {
        return ifTop;
    }

    /**
     * 是否置顶
     */
    public void setIfTop(Integer ifTop) {
        this.ifTop = ifTop;
    }

    /**
     * 是否公开
     */
    public Integer getIfPrivate() {
        return ifPrivate;
    }

    /**
     * 是否公开
     */
    public void setIfPrivate(Integer ifPrivate) {
        this.ifPrivate = ifPrivate;
    }

    /**
     * 
     */
    public Long getHeat() {
        return heat;
    }

    /**
     * 
     */
    public void setHeat(Long heat) {
        this.heat = heat;
    }

    /**
     * 
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 审核状态
（0：审核中 1：通过  -1：失败 ）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 审核状态
（0：审核中 1：通过  -1：失败 ）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTreeCatalogId() == null ? other.getTreeCatalogId() == null : this.getTreeCatalogId().equals(other.getTreeCatalogId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getLabels() == null ? other.getLabels() == null : this.getLabels().equals(other.getLabels()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getOriginContent() == null ? other.getOriginContent() == null : this.getOriginContent().equals(other.getOriginContent()))
            && (this.getCoverImageUrl() == null ? other.getCoverImageUrl() == null : this.getCoverImageUrl().equals(other.getCoverImageUrl()))
            && (this.getIfReprinted() == null ? other.getIfReprinted() == null : this.getIfReprinted().equals(other.getIfReprinted()))
            && (this.getReprintedUrl() == null ? other.getReprintedUrl() == null : this.getReprintedUrl().equals(other.getReprintedUrl()))
            && (this.getIfTop() == null ? other.getIfTop() == null : this.getIfTop().equals(other.getIfTop()))
            && (this.getIfPrivate() == null ? other.getIfPrivate() == null : this.getIfPrivate().equals(other.getIfPrivate()))
            && (this.getHeat() == null ? other.getHeat() == null : this.getHeat().equals(other.getHeat()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTreeCatalogId() == null) ? 0 : getTreeCatalogId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getLabels() == null) ? 0 : getLabels().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getOriginContent() == null) ? 0 : getOriginContent().hashCode());
        result = prime * result + ((getCoverImageUrl() == null) ? 0 : getCoverImageUrl().hashCode());
        result = prime * result + ((getIfReprinted() == null) ? 0 : getIfReprinted().hashCode());
        result = prime * result + ((getReprintedUrl() == null) ? 0 : getReprintedUrl().hashCode());
        result = prime * result + ((getIfTop() == null) ? 0 : getIfTop().hashCode());
        result = prime * result + ((getIfPrivate() == null) ? 0 : getIfPrivate().hashCode());
        result = prime * result + ((getHeat() == null) ? 0 : getHeat().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", treeCatalogId=").append(treeCatalogId);
        sb.append(", title=").append(title);
        sb.append(", labels=").append(labels);
        sb.append(", content=").append(content);
        sb.append(", originContent=").append(originContent);
        sb.append(", coverImageUrl=").append(coverImageUrl);
        sb.append(", ifReprinted=").append(ifReprinted);
        sb.append(", reprintedUrl=").append(reprintedUrl);
        sb.append(", ifTop=").append(ifTop);
        sb.append(", ifPrivate=").append(ifPrivate);
        sb.append(", heat=").append(heat);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}