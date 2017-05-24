/**
 * Created by Chenw on 2016/2/1 0001.
 */
package pkg2;
class OtherPackage{
    OtherPackage(){
        pkg1.Protection p=new pkg1.Protection();
        System.out.println("OtherPackage Constructor:");
        //System.out.println("n ="+p.n);
        //System.out.println("n_pri ="+p.n_pri);
        //System.out.println("n_pro ="+p.n_pro);
        System.out.println("n_pub ="+p.n_pub);
    }
}