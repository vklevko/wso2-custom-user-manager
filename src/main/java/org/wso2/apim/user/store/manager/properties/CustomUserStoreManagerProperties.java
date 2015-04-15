package org.wso2.apim.user.store.manager.properties;

import org.wso2.carbon.user.api.Property;

import java.util.ArrayList;

/**
 * Created by vklevko on 15-4-2015.
 */
public class CustomUserStoreManagerProperties {
    public static final ArrayList<Property> A_STAD_USERSTORE_PROPERTIES = new ArrayList();
    public static final ArrayList<Property> A_STAD_OPTIONAL_USERSTORE_PROPERTIES = new ArrayList();

    private static void setMandatoryProperty(String name, String value, String description) {
        Property property = new Property(name, value, description, (Property[])null);
        A_STAD_USERSTORE_PROPERTIES.add(property);
    }

    private static void setOptionalProperty(String name, String value, String description) {
        Property property = new Property(name, value, description, (Property[])null);
        A_STAD_OPTIONAL_USERSTORE_PROPERTIES.add(property);
    }

    static {
        setMandatoryProperty("ListUsersAPIEndpoint","http://localhost/api/users","API endpoint to be user to list users. Uses GET method");
        setOptionalProperty("ListUserRolesAPIEndpoint", "http://localhost/api/users/roles", "API endpoint to list roles available within user store. Uses GET method.");
    }
}
