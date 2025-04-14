/*
 * Copyright Broker (SFPB). All rights reserved,
 * Licence terms: https://github.com/jnightneko/Broker?tab=BSD-3-Clause-1-ov-file
 */
package gt.edu.umes.broker.gateway;

import gt.edu.umes.broker.gateway.model.AbstractBKModel;
import gt.edu.umes.broker.gateway.model.BKErrorResponseModel;
import gt.edu.umes.broker.gateway.model.MetaData;

/**
 *
 * @author wil
 */
public final class Gateway {
    
    public static String bkBuildHostService(MetaData data) {
        StringBuilder buff = new StringBuilder();
        buff.append(Configuration.MSVC_CONNECTOR_HOST.get())
            .append(Configuration.MSVC_CONNECTOT_PATH.get());
        return String.valueOf(buff);
    }
    
    public static BKErrorResponseModel bkNewError(String msg, int code) { return bkNewError(null, msg, code); }
    public static BKErrorResponseModel bkNewError(MetaData metaData, String msg, int code) {
        assert msg != null || code < 0;
        BKErrorResponseModel error = new BKErrorResponseModel(msg, code);
        error.setMetaData(metaData);
        return error;
    }
    
    public static boolean bkCheckRequest(AbstractBKModel<Object> model) {
        if (model == null) {
            return false;
        }
        
        MetaData data = model.getMetaData();
        if (data == null || (data.getEndPoint() == null || data.getEndPoint().isEmpty())) {
            return false;
        }
        return true;
    }
}
