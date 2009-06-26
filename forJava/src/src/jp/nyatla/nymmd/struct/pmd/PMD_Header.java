/* 
 * PROJECT: MMD for Java
 * --------------------------------------------------------------------------------
 * This work is based on the ARTK_MMD v0.1 
 *   PY
 * http://ppyy.web.fc2.com/
 * py1024<at>gmail.com
 * http://www.nicovideo.jp/watch/sm7398691
 *
 * The MMD for Java is Java version MMD class library.
 * Copyright (C)2009 nyatla
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this framework; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 * For further information please contact.
 *	http://nyatla.jp/
 *	<airmail(at)ebony.plala.or.jp>
 * 
 */
package jp.nyatla.nymmd.struct.pmd;

import jp.nyatla.nymmd.*;
import jp.nyatla.nymmd.struct.*;

public class PMD_Header implements StructType
{
	public final static int SIZE_OF_STRUCT=3+4+20+256;
	public String szMagic;
	public float fVersion;
	public String szName;
	public String szComment;
	
	public void read(DataReader i_reader) throws MmdException
	{
		this.szMagic=i_reader.readAscii(3);
		//
		this.fVersion=i_reader.readFloat();
		//szName
		this.szName=i_reader.readAscii(20);

		//szComment
		this.szComment=i_reader.readAscii(256);
		return;
	}
/*
	char	szMagic[3];		// "Pmd"
	float	fVersion;		// PMDバージョン番号
	char	szName[20];		// モデル名
	char	szComment[256];	// コメント(著作権表示など)
*/
}