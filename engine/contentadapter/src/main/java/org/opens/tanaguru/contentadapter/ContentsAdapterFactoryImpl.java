/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2014  Open-S Company
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
package org.opens.tanaguru.contentadapter;

import java.util.List;
import org.opens.tanaguru.contentadapter.util.AdaptationActionVoter;
import org.opens.tanaguru.entity.audit.Content;

/**
 *
 * @author enzolalay
 */
public class ContentsAdapterFactoryImpl implements ContentsAdapterFactory {

    private AdaptationActionVoter xmlizeVoter;
    public void setXmlizeVoter(AdaptationActionVoter xmlizeVoter) {
        this.xmlizeVoter = xmlizeVoter;
    }
    
    private AdaptationActionVoter parseHtmlVoter;
    public void setParseHtmlVoter(AdaptationActionVoter parseHtmlVoter) {
        this.parseHtmlVoter = parseHtmlVoter;
    }
    
    public ContentsAdapterFactoryImpl() {
        super();
    }

    @Override
    public ContentsAdapter create(
            List<Content> contentList,
            boolean writeCleanHtmlInFile,
            String tempFolderRootPath,
            HTMLCleaner htmlCleaner,
            HTMLParser htmlParser) {
        ContentsAdapterImpl contentsAdapter = new ContentsAdapterImpl(
                contentList,
                writeCleanHtmlInFile,
                tempFolderRootPath,
                htmlCleaner,
                htmlParser);
        if (parseHtmlVoter != null) {
            contentsAdapter.setParseHtmlVoter(parseHtmlVoter);
        }
        if (xmlizeVoter != null) {
            contentsAdapter.setXmlizeVoter(xmlizeVoter);
        }
        return contentsAdapter;
    }

}