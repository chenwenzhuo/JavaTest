/**
 * Created by Chenw on 2016/2/1 0001.
 */
package pkg1;
class SamePackage{
    SamePackage(){
        System.out.print("In SamePackage---");
        Protection p=new Protection();
        System.out.println("SamePackage Constructor:");
        System.out.println("n ="+p.n);
        //System.out.println("n_pri ="+p.n_pri);
        System.out.println("n_pro ="+p.n_pro);
        System.out.println("n_pub ="+p.n_pub);
    }
}