package com.example.autism.sakil.autism;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class CareCenterCollection {

    List<CareCenterProfile> list = new ArrayList<>();
    cognitiveTestDBHelper myCareCenter;
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getName(int a) {
        return list.get(a).getName();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getContact(int a) {
        return list.get(a).getContact();
    }
    public String getEmail(int a) {
        return list.get(a).getEmail();
    }
    public String getAddress(int a) {
        return list.get(a).getAddress();
    }
    public String getAbout(int a) {
        return list.get(a).getAbout();
    }




    public void initQuestions(Context context) {
        myCareCenter = new cognitiveTestDBHelper(context);
       //get questions/choices/answers from database
        list = myCareCenter.getAllCareCenterProfile(list);
        if (myCareCenter.isCareCenterEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Autism Wing",
                    "+8801716217077","info@autismwing.com",
                    "House#809, Road#11, Avenue#06, Mirpur DOHS, Dhaka-1216, Bangladesh.",
                    "Autism Wing provides FREE consultancy services to the parents of the autistic children regarding diagnosis and intervention on Autism Spectrum Disorders"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Advanced School for Special Children (ASSC)",
                    "+8801819-199795","assc.bangladesh@gmail.com",
                    "14/22 Babor Road, Mohammadpur Dhaka 1207",
                    "ASSC is a school deal with Autistic & other neuro related children age ranging from 2.5 years to 10 years"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Alokito Shishu Treatment Based School",
                    "+8801706-035233","not provided",
                    "*Alokito Shishu, House-05, Road-02, P C Culture Housing Society, Kha-Block, Shekhertek, Mohammadpur, Dhaka.\n" +
                            "*Alokito Shishu, Plot-15, Road-31, Sector-7, Uttara Model Town, Dhaka..",
                    "Alokito Shishu is a Treatment Based School for the children with special needs including Autism, CP, AD to make them independent and inclusion in society."));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Amar Joti Special School",
                    "+8801816158787","Not provided",
                    "House# 2/5, Road# 1, Shymoli, Dhaka.",
                    "Amar Joti is a school where children with a complex disability receive quality appropriate education by making use of an IEP and thematic education"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Angels of Heaven",
                    "+8801911-524018","not provided",
                    "House#32, Road#03, Sector#11, Uttara, Dhaka, Bangladesh",
                    "Preschool and Autism Care Center. General medical check-up, SLT, OT, & PT."));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("William & Mary Taylor Inclusive School",
                    "+880-2-7745464/5","Not provided",
                    "Plot # A/5, Block # A, Mirpur # 14.",
                    " CRP provides medical treatment, rehabilitation and support services focusing on physical, emotional, social, psychological and economic aspects. It promotes the development of skilled personnel in health care and rehabilitation in the country"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Angels Care Foundation (ACF)",
                    "+8801713-365302","Not provided",
                    "House#16/5, Block-C, Tajmahal Road, Mohammadpur, Dhaka-1207.",
                    "It is a welfare foundation for the children with intellectual disability and autism or other neurodevelopmental disability"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Autism Welfare Foundation (AWF).",
                    "+8801552363575","adminawf2004@gmail.com",
                    "Shamlapur, Moddhercor, Keraniganj, Dhaka-1310..",
                    "AWF is a non-profitable, non-government, voluntary welfare organization was established on April 4, 2004, aiming to train and educate the children to perform their maximum strengths and interests, and making them able to support themselves"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Beautiful Mind",
                    "+88 02 891 7699","azizurch@agni.com",
                    "Plot # 1145, Road # 6/A, Dolipara, Sector # 5, Uttara, Dhaka -1230.",
                    "Beautiful Mind has modern –equipped physiotherapy, speech-therapy and occupational-therapy laboratories to support children’s clinical needs. It follows the National Curriculum and the Foundation Stage but modified by school staff to meet the needs of pupils with Autism and Mental Retardation"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Autism Rehab Centre (Therapy Station)",
                    "Not provided","not provided",
                    "117, Shantinagar, Dhaka-1217 (Opposite to No.1 gate of Rajarbag Police Line)",
                    "Special School for Speech & Language Therapy and Occupational Therapy."));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("Bangladesh ABA Centre for Autism",
                    "01760207677","Not provided",
                    "House# 76, Road# 17, Sector# 11, Uttara, Dhaka-1230",
                    "Bangladesh ABA Centre for Autism has been serving children and adults with Autism and Learning difficulties since 2008"));
            myCareCenter.addInitialCareCenter(new CareCenterProfile("CHILD Foundation",
                    "+88-02-9851895","Ummay Asma Bhuyan (Coordinator)",
                    "Taher Tower, Plot # 10(5th Floor), Gulshan North Circle, Gulshan-2, Dhaka-1212",
                    "CHILD Foundation is a non-profit, non-government, non-political voluntary welfare organization working for individuals with special needs"));
            list = myCareCenter.getAllCareCenterProfile(list);//get list from database again

        }
    }
}
