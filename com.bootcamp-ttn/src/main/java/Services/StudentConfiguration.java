package Services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Services.StudentConfiguration", description = "This file is there for the configuration of other services")
public @interface StudentConfiguration {
    @AttributeDefinition(name = "classes.Student Number", type = AttributeType.INTEGER, description = "Total number of Students allowed")
    int Student_Number() default 5;

    @AttributeDefinition(name = "Passing Marks", type = AttributeType.INTEGER, description = "Passing Marks")
    int Pass_Marks() default 75;
}
