/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tgol.entity.decorator.tanaguru.subject;

import org.opens.tgol.util.HttpStatusCodeFamily;
import java.util.Collection;
import java.util.List;
import org.opens.tanaguru.entity.audit.Audit;
import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.entity.reference.Scope;
import org.opens.tanaguru.entity.reference.Theme;
import org.opens.tanaguru.entity.service.subject.WebResourceDataService;
import org.opens.tanaguru.entity.subject.WebResource;

/**
 * This interface decorates the WebResourceDataService interface defined in
 * the tanaguru API and adds more primitives.
 * 
 * @author jkowalczyk
 */
public interface WebResourceDataServiceDecorator extends WebResourceDataService {

    /**
     *
     * @param webresourceId
     * @return
     *          the id of the parent webresource for a given webresource.
     */
    Long getParentWebResourceId(Long webresourceId);

    /**
     *
     * @param parentWebresourceId
     * @param nbOfResult
     * @return
     */
    Collection<? extends Object> getFailedWebResourceSortedByTest(
            WebResource webResource, 
            Audit audit,
            int nbOfResult);

    /**
     *
     * @param parentWebresourceId
     * @param nbOfResult
     * @return
     */
    Collection<? extends Object> getFailedWebResourceSortedByOccurrence(
            WebResource webResource, 
            Audit audit,
            int nbOfResult);

    /**
     *
     * @param parentWebresourceId
     * @param nbOfResult
     * @return
     */
    Collection<? extends Object> getFailedTestByOccurrence(
            WebResource webResource, 
            Audit audit,
            int nbOfResult);

    /**
     *
     * @param webResourceId
     * @return
     */
    WebResource ligthRead(Long webResourceId);

    /**
     *
     * @param webResourceId
     * @return
     */
    WebResource deepRead(Long webResourceId);

    /**
     *
     * @param parentWebresourceId
     * @param testSolution
     * @return
     */
    Long getResultCountByResultType(
            WebResource webResource,
            Audit audit,
            TestSolution testSolution);

    /**
     *
     * @param parentWebresourceId
     * @param testSolution
     * @return
     */
    Collection<? extends Object> getResultCountByResultTypeAndTheme(
            WebResource webResource,
            Audit audit,
            TestSolution testSolution,
            int nb0fResult);

    /**
     *
     * @param parentWebresourceId
     * @return
     */
    Long getChildWebResourceCount(WebResource webresourceId);

    /**
     *
     * @param webResource
     * @param scope
     * @return
     */
    Collection<ProcessResult> getProcessResultListByWebResourceAndScope(
            WebResource webResource,
            Scope scope);
    
    /**
     * 
     * @param webResource
     * @param scope
     * @param themeList
     * @param testSolutionList
     * @return
     */
    Collection<ProcessResult> getProcessResultListByWebResourceAndScope(
            WebResource webResource,
            Scope scope,
            String theme,
            String testSolution);


    /**
     *
     * @param parentWebresourceId
     * @param testSolution
     * @param theme
     * @return
     */
    Long getResultCountByResultTypeAndTheme(
            WebResource webResource,
            Audit audit,
            TestSolution testSolution,
            Theme theme);

    /**
     *
     * @param webResource
     * @return
     */
    Collection<? extends Object> getChildUrlList(
            WebResource webResource,
            Audit audit);

    /**
     *
     * @param webResource
     * @param scope
     * @return
     */
    boolean hasAuditSiteScopeTest(WebResource webResource, Scope scope);

    /**
     *
     * @param webResource
     * @param audit
     * @param isRawMark
     * @return
     */
    Float getMarkByWebResourceAndAudit(WebResource webResource, Audit audit, boolean isRawMark);
    
    /**
     * 
     * @param idAudit
     * @param httpStatusCode
     * @param containingValue
     * @return
     */
    Long getWebResourceCountByAuditAndHttpStatusCode(
            Long idAudit,
            HttpStatusCodeFamily httpStatusCode,
            String containingValue);
    
    /**
     * 
     * @param idAudit
     * @param httpStatusCode
     * @param nbOfElements
     * @param window
     * @param sortDirection
     * @param sortCriterion
     * @param containingValue
     * @return
     */
    Collection<? extends Object> getWebResourceListByAuditAndHttpStatusCode(
            Long idAudit,
            HttpStatusCodeFamily httpStatusCode,
            int nbOfElements,
            int window,
            int sortDirection,
            String sortCriterion,
            String containingValue);
}
