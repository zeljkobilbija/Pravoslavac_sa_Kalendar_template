package com.interfacemockup.kalendar;

import android.net.Uri;


import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;

public class DynamicLinksUtil {



    // [START ddl_generate_content_link]
    public static Uri generateContentLink() {
        Uri baseUrl = Uri.parse("https://pravoslavac.page.link/download");
        String domain = "https://apps.apple.com/it/app/pravoslavac/id1234033120";

        DynamicLink link = FirebaseDynamicLinks.getInstance()
                .createDynamicLink()
                .setLink(baseUrl)
                .setDomainUriPrefix(domain)
                .setIosParameters(new DynamicLink.IosParameters.Builder("com.bilbija.Pravoslavac").build())
               // .setAndroidParameters(new DynamicLink.AndroidParameters.Builder("com.your.packageName").build())
                .buildDynamicLink();

        return link.getUri();
    }
    // [END ddl_generate_content_link]

}


