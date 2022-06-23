package com.hacakathon.vegetable.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="IMG_INFO")
public class ImgInfo {
    @Id
    @Column(name="IMG_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long imgId;

    @ManyToOne
    @JoinColumn(name = "VEGE_CONTENT_ID")
    private VegeContent vegeContent;

    @ManyToOne
    @JoinColumn(name = "RECIPE_CONTENT_ID")
    private RecepiContent recepiContent;

    @Column(name = "IMG_EXE")
    String imgEXE;

    @Column(name = "IMG_NAME")
    String imgName;

    @Column(name = "IMG_MAKER")
    String imgMaker;
}
