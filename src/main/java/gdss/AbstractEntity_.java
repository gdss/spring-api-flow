package gdss;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import java.util.UUID;

@StaticMetamodel(AbstractEntity.class)
public abstract class AbstractEntity_ {

    public static volatile SingularAttribute<AbstractEntity, Date> createdDate;
    public static volatile SingularAttribute<AbstractEntity, Date> lastModifiedDate;
    public static volatile SingularAttribute<AbstractEntity, UUID> id;
    public static volatile SingularAttribute<AbstractEntity, Integer> version;

    public static final String CREATED_DATE = "createdDate";
    public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
    public static final String ID = "id";
    public static final String VERSION = "version";

}

