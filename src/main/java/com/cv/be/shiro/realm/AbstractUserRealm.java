package com.cv.be.shiro.realm;

import com.cv.be.entity.Admin;
import com.cv.be.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhou_wb on 2017/5/13.
 */
public abstract class AbstractUserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(AbstractUserRealm.class);

    @Autowired
    private AdminService adminService;
    //获取用户组的权限信息
    public abstract UserRolesAndPermissions doGetGroupAuthorizationInfo(Admin admin);
    //获取用户角色的权限信息
    public abstract UserRolesAndPermissions doGetRoleAuthorizationInfo(Admin admin);

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String currentLoginName = (String) principals.getPrimaryPrincipal();
        Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        //从数据库中获取当前登录用户的详细信息
        Admin admin = adminService.findAdminByAccount(currentLoginName);
        if (null != admin) {
            UserRolesAndPermissions groupContainer = doGetGroupAuthorizationInfo(admin);
            UserRolesAndPermissions roleContainer = doGetGroupAuthorizationInfo(admin);
            userRoles.addAll(groupContainer.getUserRoles());
            userRoles.addAll(roleContainer.getUserRoles());
            userPermissions.addAll(groupContainer.getUserPermissions());
            userPermissions.addAll(roleContainer.getUserPermissions());
        } else {
            throw new AuthorizationException();
        }
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(userRoles);
        authorizationInfo.addStringPermissions(userPermissions);
        logger.info("###【获取角色成功】[SessionId] => {}", SecurityUtils.getSubject().getSession().getId());
        return authorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        Admin admin = adminService.findAdminByAccount(token.getUsername());
        if (admin != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token.getUsername()
                    , admin.getPwd(), getName());
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(admin.getSalt()));
            return simpleAuthenticationInfo;
        }
        return null;
    }

    protected class UserRolesAndPermissions {
        Set<String> userRoles;
        Set<String> userPermissions;

        public UserRolesAndPermissions(Set<String> userRoles, Set<String> userPermissions) {
            this.userRoles = userRoles;
            this.userPermissions = userPermissions;
        }

        public Set<String> getUserRoles() {
            return userRoles;
        }

        public Set<String> getUserPermissions() {
            return userPermissions;
        }
        }
}
