/* 
 * PROJECT: MMD for Java
 * --------------------------------------------------------------------------------
 * This work is based on the ARTK_MMD v0.1 
 *   PY
 * http://ppyy.hp.infoseek.co.jp/
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
package jp.nyatla.nymmd.struct;


import jp.nyatla.nymmd.MmdException;
import jp.nyatla.nymmd.types.*;

public class StructReader
{
	public static void read(MmdColor4 i_dest,DataReader i_reader)  throws MmdException
	{
		i_dest.r=i_reader.readFloat();
		i_dest.g=i_reader.readFloat();
		i_dest.b=i_reader.readFloat();
		i_dest.a=i_reader.readFloat();
		return;
	}
	public static void read(MmdColor3 i_dest,DataReader i_reader)  throws MmdException
	{
		i_dest.r=i_reader.readFloat();
		i_dest.g=i_reader.readFloat();
		i_dest.b=i_reader.readFloat();
		return;
	}
	public static void read(MmdTexUV i_dest,DataReader i_reader)  throws MmdException
	{
		i_dest.u=i_reader.readFloat();
		i_dest.v=i_reader.readFloat();
		return;
	}
	public static void read(MmdVector3 i_dest,DataReader i_reader)  throws MmdException
	{
		i_dest.x=i_reader.readFloat();
		i_dest.y=i_reader.readFloat();
		i_dest.z=i_reader.readFloat();
		return;
	}	
	public static void read(MmdVector4 i_dest,DataReader i_reader) throws MmdException
	{
		i_dest.x=i_reader.readFloat();
		i_dest.y=i_reader.readFloat();
		i_dest.z=i_reader.readFloat();
		i_dest.w=i_reader.readFloat();
		return;
	}	
}
