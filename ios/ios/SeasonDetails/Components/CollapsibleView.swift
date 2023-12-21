//
//  CollapsibleView.swift
//  tv-maniac
//
//  Created by Thomas Kioko on 21.12.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct Collapsible<Content: View>: View {
    
    var episodeCount: Int64
    var watchProgress: CGFloat
    var isCollapsed: Bool = false
    var onCollapseClicked: () -> Void
    var onWatchedStateClicked: () -> Void
    
    @State var content: () -> Content
    @State private var collapsed: Bool = false
    
    
    var body: some View {
        VStack {
            ZStack {
                VStack {
                    Spacer()
                    HStack {
                        HStack {
                            Image(systemName: collapsed ? "chevron.down" : "chevron.up")
                                .aspectRatio(contentMode: .fit)
                                .padding(.horizontal, 16)
                            
                            Text("Episodes")
                                .font(.title3)
                                .fontWeight(.semibold)
                            
                            Spacer()
                            
                        }
                        .contentShape(Rectangle())
                        .onTapGesture {
                            withAnimation {
                                onCollapseClicked()
                                collapsed.toggle()
                            }
                        }
                        
                        Text("\(episodeCount)")
                            .font(.callout)
                            .fontWeight(.semibold)
                            .alignmentGuide(.view) { d in d[HorizontalAlignment.center] }
                            .padding(.trailing, 8)
                        
                        Image(systemName: "checkmark.circle")
                            .resizable()
                            .frame(width: 28.0, height: 28.0)
                            .fontDesign(.rounded)
                            .font(.callout)
                            .fontWeight(.regular)
                            .foregroundColor(.secondary)
                            .alignmentGuide(.view) { d in d[HorizontalAlignment.trailing] }
                            .padding(.trailing, 16)
                            .onTapGesture { onWatchedStateClicked() }
                    }
                    .padding(.bottom, 4)
                    
                    
                    Spacer()
                    
                    ProgressView(value: watchProgress, total: 1)
                        .progressViewStyle(
                            RoundedRectProgressViewStyle(progressIndicatorHeight: DimensionConstants.progressIndicatorHeight)
                        )
                }
                .frame(height: DimensionConstants.frameHeight)
                .background(Color.content_background)
                .cornerRadius(DimensionConstants.cornerRadius)
            }
            .padding(.horizontal)
            
            VStack {
                content()
            }
            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: collapsed ? 0 : .none)
            .clipped()
            .animation(
                Animation.easeInOut(duration: 0), value: collapsed
            )
            .transition(.slide)
        }
        .onAppear {
            collapsed = isCollapsed
        }
    }
}

private struct DimensionConstants {
    static let frameHeight: CGFloat = 68
    static let cornerRadius: CGFloat = 4
    static let progressIndicatorHeight: CGFloat = 4
}

#Preview {
    VStack{
        Spacer()
        
        Collapsible(
            episodeCount: 25,
            watchProgress: 0.6,
            isCollapsed: false,
            onCollapseClicked: { },
            onWatchedStateClicked: { }
        ){
            VStack {
                
            }
        }
        Spacer()
    }
    .background(Color.background)
}
