/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author wicktus
 */
public interface PhoneFacadeInterface {

    public PhoneDTO createNumber(Phone phone);

    public PhoneDTO removeNumber(Phone phone);

    public PhoneDTO editNumber(Phone phone);
	
	public getPhoneDTO getPhone(int id);

}