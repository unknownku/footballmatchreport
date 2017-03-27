/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advdb.footballclub.dialect;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.SQLServer2012Dialect;
import org.hibernate.engine.jdbc.dialect.internal.StandardDialectResolver;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolver;

/**
 *
 * @author apichart
 */
public class ScopeStandardDialectResolver implements DialectResolver{

    @Override
    public Dialect resolveDialect(DialectResolutionInfo info) {
        Dialect customDialectResolver = customDialectResolver(info);
        return customDialectResolver;
    }
    
    private Dialect customDialectResolver(DialectResolutionInfo info) {
        final String databaseName = info.getDatabaseName();
        final int majorVersion = info.getDatabaseMajorVersion();
        if (isSqlServer2014(databaseName, majorVersion)) {
            return new SQLServer2012Dialect(); 
        } else {
            return StandardDialectResolver.INSTANCE.resolveDialect(info);
        }
    }

    private boolean isSqlServer2014(final String databaseName, final int majorVersion) {
        return databaseName.startsWith("Microsoft SQL Server") && majorVersion == 12;
    }

}
