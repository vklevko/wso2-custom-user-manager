package org.wso2.apim.user.store.manager;

import be.digipolis.wso2.apim.user.store.manager.properties.AStadUserStoreManagerProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.user.api.Properties;
import org.wso2.carbon.user.api.Property;
import org.wso2.carbon.user.api.RealmConfiguration;
import org.wso2.carbon.user.api.Tenant;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.common.AbstractUserStoreManager;
import org.wso2.carbon.user.core.common.RoleContext;
import org.wso2.carbon.user.core.jdbc.JDBCUserStoreManager;



import java.util.*;

public class CustomUserStoreManager extends AbstractUserStoreManager {

    public CustomUserStoreManager() {

    }

    /*public AStadUserStoreManager(RealmConfiguration realmConfig, Map<String, Object> properties, ClaimManager claimManager, ProfileConfigurationManager profileManager, UserRealm realm, Integer tenantId) throws UserStoreException {
        this(realmConfig, properties, claimManager, profileManager, realm, tenantId, false);
    }

    public AStadUserStoreManager(RealmConfiguration realmConfig, Map<String, Object> properties, ClaimManager claimManager, ProfileConfigurationManager profileManager, UserRealm realm, Integer tenantId, boolean skipInitData) throws UserStoreException {
        this();
    }

    public AStadUserStoreManager(RealmConfiguration realmConfig, ClaimManager claimManager, ProfileConfigurationManager profileManager) throws UserStoreException {
        this();
    }*/


    private static Log log = LogFactory.getLog(CustomUserStoreManager.class);


    @Override
    public Map<String, String> getUserPropertyValues(String userName, String[] propertyNames, String profileName) throws UserStoreException {
        return new HashMap<String, String>() {{
            put("prop1", "value1");
            put("prop2", "value2");
            put("prop3", "value3");
            put("prop4", "value4");
            put("prop5", "value5");
        }};
    }

    @Override
    public boolean doCheckExistingRole(String s) throws UserStoreException {
        return false;
    }

    @Override
    public RoleContext createRoleContext(String s) throws UserStoreException {
        return null;
    }

    @Override
    public boolean doCheckExistingUser(String s) throws UserStoreException {
        return false;
    }

    @Override
    public String[] getUserListFromProperties(String property, String value, String profileName) throws UserStoreException {
        return new String[0];
    }

    @Override
    public boolean doAuthenticate(String userName, Object credential) throws UserStoreException {
        if (userName != null && credential != null) {
            userName = userName.trim();
            userName = this.replaceEscapeCharacters(userName);
            String password = (String) credential;
            password = password.trim();
            if (!userName.equals("") && !password.equals("")) {
                log.info("Authenticating user with credentials: " + userName + "/" + password);
                if ("auser1".equals(userName) && "welcome".equals(password)) {
                    return true;
                }

            }

        }
        return false;
    }

    @Override
    public void doAddUser(String s, Object o, String[] strings, Map<String, String> map, String s1, boolean b) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doUpdateCredential(String s, Object o, Object o1) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doUpdateCredentialByAdmin(String s, Object o) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doDeleteUser(String s) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doSetUserClaimValue(String s, String s1, String s2, String s3) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doSetUserClaimValues(String s, Map<String, String> map, String s1) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doDeleteUserClaimValue(String s, String s1, String s2) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doDeleteUserClaimValues(String s, String[] strings, String s1) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doUpdateUserListOfRole(String s, String[] strings, String[] strings1) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doUpdateRoleListOfUser(String s, String[] strings, String[] strings1) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public String[] doGetExternalRoleListOfUser(String userName, String filter) throws UserStoreException {
        return new String[]{"ExtRole1", "ExtRole2", "ExtRole3", "ExtRole4", "ExtRole5"};
    }

    @Override
    public String[] doGetSharedRoleListOfUser(String userName, String tenantDomain, String filter) throws UserStoreException {
        if (tenantDomain != null && tenantDomain.trim().length() > 0 && !"carbon.super".equalsIgnoreCase(tenantDomain.trim())) {
            if ("auser1".equals(userName)) {
                return new String[]{"ExtRole1", "ExtRole2", "ExtRole3", "ExtRole4", "ExtRole5"};
            }
        }
        return new String[0];
    }

    @Override
    public void doAddRole(String s, String[] strings, boolean b) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doDeleteRole(String s) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doUpdateRoleName(String s, String s1) throws UserStoreException {
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public String[] doGetRoleNames(String filter, int maxItemLimit) throws UserStoreException {
        return new String[]{"ExtRole1", "ExtRole2", "ExtRole3", "ExtRole4", "ExtRole5", "ExtRole6", "ExtRole7", "ExtRole8", "ExtRole9", "ExtRole10"};
    }

    @Override
    public String[] doListUsers(String filter, int maxItemLimit) throws UserStoreException {
        List users = new ArrayList();
        return new String[]{"auser1", "auser2", "auser3", "auser4", "auser5"};
    }

    @Override
    public String[] doGetDisplayNamesForInternalRole(String[] userNames) throws UserStoreException {
        return new String[]{"auser1", "auser2", "auser3", "auser4", "auser5"};
    }

    @Override
    public boolean doCheckIsUserInRole(String userName, String roleName) throws UserStoreException {
        List<String> userRoles = Arrays.asList(doGetRoleListOfUser(userName, null));
        return userRoles.contains(roleName);
    }

    @Override
    public String[] doGetSharedRoleNames(String tenantDomain, String filter, int maxItemLimit) throws UserStoreException {
        return new String[0];
    }

    @Override
    public String[] doGetUserListOfRole(String roleName, String filter) throws UserStoreException {
        if ("ExtRole1".equals(roleName) || "ExtRole2".equals(roleName) || "ExtRole3".equals(roleName) || "ExtRole4".equals(roleName) || "ExtRole5".equals(roleName)) {
            return new String[]{"auser1"};
        }
        return new String[0];
    }

    public String[] getProfileNames(String s) throws UserStoreException {
        return new String[]{"default"};
    }

    public String[] getAllProfileNames() throws UserStoreException {
        return new String[]{"default"};
    }

    public boolean isReadOnly() throws UserStoreException {
        return true;
    }

    public Date getPasswordExpirationTime(String s) throws UserStoreException {
        return null;
    }

    public int getUserId(String s) throws UserStoreException {
        return 0;
    }

    public int getTenantId(String s) throws UserStoreException {
        throw new UserStoreException("Invalid operation");
    }

    public int getTenantId() throws UserStoreException {
        return 0;
    }

    public Map<String, String> getProperties(org.wso2.carbon.user.core.tenant.Tenant tenant) throws UserStoreException {
        return this.realmConfig.getUserStoreProperties();
    }

    public Map<String, String> getProperties(Tenant tenant) throws org.wso2.carbon.user.api.UserStoreException {
        return this.realmConfig.getUserStoreProperties();
    }

    public boolean isMultipleProfilesAllowed() {
        return false;
    }

    public void addRememberMe(String userName, String token) throws org.wso2.carbon.user.api.UserStoreException {
        JDBCUserStoreManager jdbcUserStore = new JDBCUserStoreManager(this.dataSource, this.realmConfig, this.realmConfig.getTenantId(), false);
        jdbcUserStore.addRememberMe(userName, token);
    }

    public boolean isValidRememberMeToken(String userName, String token) throws org.wso2.carbon.user.api.UserStoreException {
        try {
            if (this.isExistingUser(userName)) {
                JDBCUserStoreManager e = new JDBCUserStoreManager(this.dataSource, this.realmConfig, this.realmConfig.getTenantId(), false);
                return e.isExistingRememberMeToken(userName, token);
            }
        } catch (Exception var4) {
            log.error("Validating remember me token failed for" + userName);
        }

        return false;
    }

    public Properties getDefaultUserStoreProperties() {
        Properties properties = new Properties();
        properties.setMandatoryProperties((Property[]) AStadUserStoreManagerProperties.A_STAD_USERSTORE_PROPERTIES.toArray(new Property[AStadUserStoreManagerProperties.A_STAD_USERSTORE_PROPERTIES.size()]));
        properties.setOptionalProperties((Property[]) AStadUserStoreManagerProperties.A_STAD_OPTIONAL_USERSTORE_PROPERTIES.toArray(new Property[AStadUserStoreManagerProperties.A_STAD_OPTIONAL_USERSTORE_PROPERTIES.size()]));
        return properties;
    }

    public boolean isBulkImportSupported() throws UserStoreException {
        return false;
    }

    public RealmConfiguration getRealmConfiguration() {
        return this.realmConfig;
    }
}
