package ua.com.codefire.mailer.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ua.com.codefire.mailer.entity.EmlBodyBlank;
import ua.com.codefire.mailer.entity.EmlHeaderBlank;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-22T17:14:12")
@StaticMetamodel(EmlBlank.class)
public class EmlBlank_ { 

    public static volatile SingularAttribute<EmlBlank, EmlBodyBlank> blankBody;
    public static volatile SingularAttribute<EmlBlank, String> blankName;
    public static volatile SingularAttribute<EmlBlank, Integer> emlBlankId;
    public static volatile SingularAttribute<EmlBlank, EmlHeaderBlank> blankHeader;

}