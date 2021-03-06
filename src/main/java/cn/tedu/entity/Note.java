package cn.tedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Note implements Serializable{

	/**
	 * cn_note_id
		cn_notebook_id
		cn_user_id
		cn_note_status_id
		cn_note_type_id
		cn_note_title
		cn_note_body
		cn_note_create_time
		cn_note_last_modify_time
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String notebookId;
	private String userId;
	private String typeId;
	private String statusId;
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public Note(String id, String notebookId, String userId, String typeId, String statusId, String title, String body,
			Timestamp createTime, Timestamp lastModifyTime) {
		super();
		this.id = id;
		this.notebookId = notebookId;
		this.userId = userId;
		this.typeId = typeId;
		this.statusId = statusId;
		this.title = title;
		this.body = body;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}
	private String title;
	private String body;
	private Timestamp createTime;
	private Timestamp lastModifyTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNotebookId() {
		return notebookId;
	}
	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", notebookId=" + notebookId + ", userId=" + userId + ", statusId=" + statusId
				+ ", title=" + title + ", body=" + body + ", createTime=" + createTime + ", lastModifyTime="
				+ lastModifyTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Note(String id, String notebookId, String userId, String statusId, String title, String body,
			Timestamp createTime, Timestamp lastModifyTime) {
		super();
		this.id = id;
		this.notebookId = notebookId;
		this.userId = userId;
		this.statusId = statusId;
		this.title = title;
		this.body = body;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
