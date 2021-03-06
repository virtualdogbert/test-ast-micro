micronaut {
    application {
        name = 'test-ast-micro'
    }
}

micronaut {
    security {
        enabled = true
        endpoints {
            login {
                enabled = true
            }
            logout {
                enabled = true
            }
        }
        session {
            enabled = true
            loginSuccessTargetUrl = '/'
            loginFailureTargetUrl = '/'
        }
    }
}

hibernate {
    hbm2ddl {
        auto = 'update'
    }
    cache {
        queries = false
        use_second_level_cache = true
        use_query_cache = false
        region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory'
    }
}

dataSource {
    driverClassName = 'org.h2.Driver'
    username = 'sa'
    password = ''
    url = 'jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE'
    pooled = true
    jmxExport = true
}

