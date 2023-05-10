package com.example.demo.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Entityのベースクラス
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @JsonValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "delete_flg", nullable = false)
    private Boolean deleteFlg;

    // @Version
    // @Column(name = "version_no", nullable = false)
    // private Integer versionNo;

    // @CreatedDate
    // @Column(name = "created_at", nullable = false)
    // private LocalDateTime createdAt;

    // @CreatedBy
    // @Column(name = "created_by", nullable = true)
    // private Long createdBy;

    // @LastModifiedDate
    // @Column(name = "updated_at", nullable = false)
    // private LocalDateTime updatedAt;

    // @LastModifiedBy
    // @Column(name = "updated_by", nullable = true)
    // private Long updatedBy;

    /**
     * IDを取得します。
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * IDをセットします。
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * DELETE_FLGを取得します。
     * @return DELETE_FLG
     */
    public Boolean isDeleteFlg() {
        return deleteFlg;
    }

    /**
     * DELETE_FLGをセットします。
     * @param deleteFlg DELETE_FLG
     */
    public void setDeleteFlg(Boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    // /**
    //  * バージョンNoを取得します。
    //  * @return バージョンNo
    //  */
    // public Integer getVersionNo() {
    //     return versionNo;
    // }

    // /**
    //  * バージョンNoをセットします。
    //  *
    //  * @param versionNo バージョンNo
    //  */
    // public void setVersionNo(Integer versionNo) {
    //     this.versionNo = versionNo;
    // }

    // /**
    //  * 登録日時を取得します。
    //  * @return 登録日時
    //  */
    // public LocalDateTime getCreatedAt() {
    //     return createdAt;
    // }

    // /**
    //  * 登録日時をセットします。
    //  * @param createdAt 登録日時
    //  */
    // public void setCreatedAt(LocalDateTime createdAt) {
    //     this.createdAt = createdAt;
    // }

    // /**
    //  * 作成者アクセスコードを取得します。
    //  *
    //  * @return 作成者アクセスコード
    //  */
    // public Optional<Long> getCreatedBy() {
    //     return Optional.ofNullable(createdBy);
    // }

    // /**
    //  * 作成者アクセスコードを設定します。
    //  * @param createUser 作成者アクセスコード
    //  */
    // public void setCreatedBy(Long createUser) {
    //     this.createdBy = createUser;
    // }

    // /**
    //  * 更新日時を取得します。
    //  * @return 更新日時
    //  */
    // public LocalDateTime getUpdatedAt() {
    //     return updatedAt;
    // }

    // /**
    //  * 更新日時をセットします。
    //  * @param updatedAt 更新日時
    //  */
    // public void setUpdatedAt(LocalDateTime updatedAt) {
    //     this.updatedAt = updatedAt;
    // }

    // /**
    //  * 更新者アクセスコードを取得します。
    //  * @return 更新者アクセスコード
    //  */
    // public Optional<Long> getUpdatedBy() {
    //     return Optional.ofNullable(updatedBy);
    // }

    // /**
    //  * 更新者アクセスコードを設定します。
    //  * @param updateUser 更新者アクセスコード
    //  */
    // public void setUpdatedBy(Long updateUser) {
    //     this.updatedBy = updateUser;
    // }
}