package Services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;

@Component(service = ConfigurationService.class, immediate = true)
@Designate(ocd = StudentConfiguration.class)
public class ClassConfigurationService implements ConfigurationService{
    StudentConfiguration studentConfiguration;
    private int pass;
    private int num;
    @Activate
    public void activate(StudentConfiguration studentConfiguration){
        num = studentConfiguration.Student_Number();
        pass = studentConfiguration.Pass_Marks();
    }
    public boolean isClassLimitReached(List l1){
        if(l1.isEmpty()){
            return true;
        }
        if(l1.size()<num){
            return true;
        }
        return false;
    }

    public int getPassingMarks(){
        return pass;
    }

}
