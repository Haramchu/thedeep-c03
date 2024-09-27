package apap.tutorial.manpromanpro.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    @Size(max = 30)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "deskripsi", columnDefinition = "TEXT", nullable = false)
    private String deskripsi;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "tanggal_mulai", columnDefinition = "DATE", nullable = false)
    private Date tanggalMulai;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "tanggal_selesai", columnDefinition = "DATE", nullable = false)
    private Date tanggalSelesai;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "update_at", columnDefinition = "TIMESTAMP")
    private Date updatedAt;

    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private Date deletedAt;

    @NotNull
    @Size(max = 30)
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_developer", referencedColumnName = "id")
    private Developer developer;

    @ManyToMany
    @JoinTable(name = "pekerja_proyek", joinColumns = @JoinColumn(name = "id_proyek"),
            inverseJoinColumns = @JoinColumn(name = "id_pekerja"))
    List<Pekerja> listPekerja;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
