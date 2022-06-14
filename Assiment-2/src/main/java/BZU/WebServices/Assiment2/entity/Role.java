package BZU.WebServices.Assiment2.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ApiModelProperty(value = "This the id Of Role" , required = false)
    private long id;
    @Column(length  =60)
    @ApiModelProperty(value = "This the Name Of Role" , required = true)
    private String name;

}
