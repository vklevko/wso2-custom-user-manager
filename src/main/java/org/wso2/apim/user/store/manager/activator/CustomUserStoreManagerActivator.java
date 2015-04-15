package org.wso2.apim.user.store.manager.activator;

import be.digipolis.wso2.apim.user.store.manager.AStadUserStoreManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.user.api.UserStoreManager;
import org.wso2.carbon.user.core.service.RealmService;

/**
 * @scr.component name="custom.user.store.manager.dscomponent" immediate=true
 * @scr.reference name="user.realmservice.default"
 * interface="org.wso2.carbon.user.core.service.RealmService"
 * cardinality="1..1" policy="dynamic" bind="setRealmService"
 * unbind="unsetRealmService"
 */
public class CustomUserStoreManagerActivator {
    private static Log log = LogFactory.getLog(CustomUserStoreManagerActivator.class);
    private static RealmService realmService;

    protected void activate(ComponentContext ctxt) {

        AStadUserStoreManager customUserStoreManager = new AStadUserStoreManager();
        ctxt.getBundleContext().registerService(UserStoreManager.class.getName(), customUserStoreManager, null);
        log.info("AStadUserStoreManager bundle activated successfully.");
    }

    protected void deactivate(ComponentContext ctxt) {
        if (log.isDebugEnabled()) {
            log.debug("AStadUserStoreManager is deactivated ");
        }
    }

    protected void setRealmService(RealmService rlmService) {
        realmService = rlmService;
    }

    protected void unsetRealmService(RealmService realmService) {
        realmService = null;
    }
}
