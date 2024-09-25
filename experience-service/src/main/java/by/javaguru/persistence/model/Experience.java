package by.javaguru.persistence.model;

import by.javaguru.persistence.util.YearMonthDateAttributeConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sequence_number", nullable = false)
    private Integer sequenceNumber;

    @Convert(converter = YearMonthDateAttributeConverter.class)
    @Column(name = "period_from", nullable = false, columnDefinition = "date")
    private YearMonth periodFrom;

    @Convert(converter = YearMonthDateAttributeConverter.class)
    @Column(name = "period_to", columnDefinition = "date")
    private YearMonth periodTo;

    @Column(name = "present_time", nullable = false)
    private Boolean presentTime;

    @Column(name = "company", nullable = false, length = 40)
    private String company;

    @Column(name = "position", nullable = false, length = 40)
    private String position;

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "duties", joinColumns = @JoinColumn(name = "experience_id"))
    @Column(name = "duty_name", nullable = false, length = 120)
    private List<String> duties = new ArrayList<>();

    @Column(name = "achievements", length = 200)
    private String achievements;

    @Column(name = "link")
    private String link;

    @Column(name = "industry_id")
    private Long industry;

//    @ManyToOne
//    @JoinColumn(name = "cv_id", insertable = false, updatable = false)
//    private CurriculumVitae curriculumVitae;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (!id.equals(that.id)) return false;
        if (!sequenceNumber.equals(that.sequenceNumber)) return false;
        if (!periodFrom.equals(that.periodFrom)) return false;
        if (!Objects.equals(periodTo, that.periodTo)) return false;
        if (!presentTime.equals(that.presentTime)) return false;
        if (!industry.equals(that.industry)) return false;
        if (!company.equals(that.company)) return false;
        if (!position.equals(that.position)) return false;
        if (!duties.equals(that.duties)) return false;
        if (!Objects.equals(achievements, that.achievements)) return false;
        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sequenceNumber, periodFrom, periodTo, presentTime,
                industry,
                company, position, duties, achievements, link);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Experience{");
        sb.append("id=").append(id);
        sb.append(", sequenceNumber=").append(sequenceNumber);
        sb.append(", periodFrom=").append(periodFrom);
        sb.append(", periodTo=").append(periodTo);
        sb.append(", presentTime=").append(presentTime);
//        sb.append(", industry=").append(industry);
        sb.append(", company='").append(company).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", duties=").append(duties.toString());
        sb.append(", achievements='").append(achievements).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
