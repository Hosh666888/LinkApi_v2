package pro.goforit.common.entity.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user
 */
public class User implements Serializable {

    private Long id;

    /**
     * 用户名
     */
    private String username;


    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer gender;


    private String email;

    /**
     * 角色
     */
    private String role;

    /**
     * 经验值
     */
    private Long experience;

    /**
     * 标记位
     */
    private Integer flag;

    /**
     * 头像url
     */
    private String avatar;


    private Long githubId;


    private String githubHomeUrl;


    private Date createTime;


    private Date updateTime;


    private String permissions;

    private static final long serialVersionUID = -1792211697627934126L;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 角色
     */
    public String getRole() {
        return role;
    }

    /**
     * 角色
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 经验值
     */
    public Long getExperience() {
        return experience;
    }

    /**
     * 经验值
     */
    public void setExperience(Long experience) {
        this.experience = experience;
    }

    /**
     * 标记位
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 标记位
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 头像url
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像url
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public Long getGithubId() {
        return githubId;
    }


    public void setGithubId(Long githubId) {
        this.githubId = githubId;
    }


    public String getGithubHomeUrl() {
        return githubHomeUrl;
    }


    public void setGithubHomeUrl(String githubHomeUrl) {
        this.githubHomeUrl = githubHomeUrl;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getPermissions() {
        return permissions;
    }


    public void setPermissions(String permissions) {
        this.permissions = permissions;
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getExperience() == null ? other.getExperience() == null : this.getExperience().equals(other.getExperience()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getGithubId() == null ? other.getGithubId() == null : this.getGithubId().equals(other.getGithubId()))
            && (this.getGithubHomeUrl() == null ? other.getGithubHomeUrl() == null : this.getGithubHomeUrl().equals(other.getGithubHomeUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPermissions() == null ? other.getPermissions() == null : this.getPermissions().equals(other.getPermissions()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getExperience() == null) ? 0 : getExperience().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getGithubId() == null) ? 0 : getGithubId().hashCode());
        result = prime * result + ((getGithubHomeUrl() == null) ? 0 : getGithubHomeUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPermissions() == null) ? 0 : getPermissions().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickName=").append(nickName);
        sb.append(", gender=").append(gender);
        sb.append(", email=").append(email);
        sb.append(", role=").append(role);
        sb.append(", experience=").append(experience);
        sb.append(", flag=").append(flag);
        sb.append(", avatar=").append(avatar);
        sb.append(", githubId=").append(githubId);
        sb.append(", githubHomeUrl=").append(githubHomeUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", permissions=").append(permissions);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}