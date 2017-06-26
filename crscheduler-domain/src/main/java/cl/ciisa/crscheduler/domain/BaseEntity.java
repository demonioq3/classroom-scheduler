package cl.ciisa.crscheduler.domain;

/**
 * Created by agustinsantiago on 6/18/17.
 */
public abstract class BaseEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    public String toString(){
        return this.getClass().getName() + "s{id:" + getId()+"}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if (! (obj instanceof BaseEntity))
            return false;

        BaseEntity otra = (BaseEntity)obj;

        if(getId()==null)
            return super.equals(obj);

        return (otra != null && obj.getClass().equals(this.getClass()) && this.getId() != null && this.getId() == otra.getId());
    }

}
